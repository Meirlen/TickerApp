package kz.ticker.android.ui

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.recyclerview.widget.LinearLayoutManager
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
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject


class TicketFragment : androidx.fragment.app.Fragment(), androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener {


    companion object {
        fun newInstance(): TicketFragment {
            return TicketFragment()
        }
    }

    private val mViewModel: TicketViewModel by viewModel()
    private lateinit var tickerAdapter: TickerAdapter
    private var dataList = mutableListOf<Currency>()
    private val router by inject<MainRouter>()


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
                router.openCurrency(context,dataList[position])
            }
        })
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        recyclerView.adapter = tickerAdapter
    }


    private fun loadData() {
        mViewModel.getCurrencies()
    }

    private fun setListeners() {
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    /**
     * Подписка на LiveData
     * @see TicketViewModel
     */

    private fun setObservers() {


        mViewModel.uiEvent.observe(this, Observer {
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
    }

    private fun showCurrencyList(list: List<Currency>) {
        dataList.clear()
        dataList.addAll(list)
        tickerAdapter.notifyDataSetChanged()
    }


    private fun showError(throwable: Throwable) {
        handleError(throwable) { title, desc ->
            snacbar(root_layout, title + desc)
        }
    }

    override fun onRefresh() {
        loadData()
    }

    private fun hideProgress() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun showProgress() {
        swipeRefreshLayout.isRefreshing = true

    }
}