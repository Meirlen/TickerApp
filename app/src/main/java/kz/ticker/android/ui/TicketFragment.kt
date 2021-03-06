package kz.ticker.android.ui

import androidx.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.data.exception.handleError
import com.example.gateway.entity.Currency
import kotlinx.android.synthetic.main.fragment_ticket.*
import kz.ticker.android.R
import kz.ticker.android.base.OnItemClickListener
import kz.ticker.android.vo.Status
import kz.ticker.android.ext.*
import kz.ticker.android.router.MainRouter
import kz.ticker.android.ui.ticket.TickerAdapter
import kz.ticker.android.utils.NetworkHandler
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject


class TicketFragment : androidx.fragment.app.Fragment(),
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {


    companion object {
        fun newInstance(): TicketFragment {
            return TicketFragment()
        }
    }

    private val mViewModel: TicketViewModel by viewModel()
    private lateinit var tickerAdapter: TickerAdapter
    private var dataList = mutableListOf<Currency>()
    private val router by inject<MainRouter>()
    private val networkHandler by inject<NetworkHandler>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setUpRecyclerView()
        setListeners()
        loadData()
    }


    private fun setUpRecyclerView() {
        tickerAdapter = TickerAdapter(dataList, object : OnItemClickListener {
            override fun onItemClicked(position: Int) {
                router.openCurrency(context, dataList[position])
            }
        })
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        recyclerView.adapter = tickerAdapter
    }


    private fun loadData(fromRemote: Boolean = false) {
        if (!networkHandler.isConnected) {
            showError(getString(R.string.no_internet_connect_error_message))
            return
        }
        mViewModel.getCurrencies(fromRemote)
    }

    private fun setListeners() {
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    /**
     * Подписка на LiveData
     * @see TicketViewModel
     */

    private fun setObservers() {


        mViewModel.currencyLiveData.observe(this, Observer {
            when (it?.status) {
                Status.LOADING -> {
                    showProgress()
                }
                Status.SUCCESS -> {
                    it.data?.let {
                        showCurrencyList(it)
                    }
                    hideProgress()

                }
                Status.ERROR -> {
                    it.error?.let {
                        showError(it)
                    }
                    hideProgress()
                }
            }
        })


        mViewModel.eventLiveData.observe(this, Observer {
            toast(it)
        })
    }

    private fun showCurrencyList(list: List<Currency>) {
        dataList.clear()
        dataList.addAll(list)
        tickerAdapter.notifyDataSetChanged()
    }


    private fun showError(throwable: Throwable) {
        handleError(throwable) { title, desc ->
            showError(title + desc)
        }

    }

    private fun showError(error: String) {
        snacbar(root_layout, error)
    }

    override fun onRefresh() {
        loadData(true)
    }

    private fun hideProgress() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun showProgress() {
        swipeRefreshLayout.isRefreshing = true

    }
}