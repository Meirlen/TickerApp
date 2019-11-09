package kz.ticker.android.router

import android.content.Context
import kz.ticker.android.ui.CurrencyActivity


class MainRouter {

    fun openCurrency(context: Context?) {
        context?.let {
            it.startActivity(CurrencyActivity.getStartIntent(it))
        }
    }
}