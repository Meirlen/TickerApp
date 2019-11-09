package kz.ticker.android.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.data.exception.handleError
import kotlinx.android.synthetic.main.fragment_ticket.*
import kz.ticker.android.R
import kz.ticker.android.vo.Status
import kz.ticker.android.ext.*
import kz.ticker.android.router.MainRouter
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.ext.android.inject


class TicketFragment : Fragment() {


    companion object {
        fun newInstance(): TicketFragment {
            return TicketFragment()
        }
    }

    private val mViewModel: TicketViewModel by viewModel()
    val router by inject<MainRouter>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        mViewModel.getCurrencies()
    }


    /**
     * Подписка на LiveData
     * @see TicketViewModel
     */

    private fun setObservers() {


        mViewModel.uiEvent.observe(this, Observer {
            when (it?.status) {
                Status.LOADING -> {
                    activity!!.hideKeyboard()
                    displayProgress()
                }
                Status.SUCCESS -> {
                    displayNormal()
                    snacbar(root_layout, it.data?.size.toString())

                }
                Status.ERROR -> {
                    it.error?.let {
                        showError(it)
                    }
                    displayNormal()
                }
            }
        })
    }


    private fun showError(throwable: Throwable) {
        handleError(throwable) { title, desc ->
            snacbar(root_layout, title + desc)
        }
    }


    private fun displayNormal() {
        mProgressBar.show()
    }

    private fun displayProgress() {
        mProgressBar.hide()
    }
}