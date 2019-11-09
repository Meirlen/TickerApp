package kz.ticker.android.router

import android.content.Context
import com.example.gateway.entity.Currency
import kz.ticker.android.ui.detail.CurrencyActivity


class MainRouter {

    fun openCurrency(context: Context?, currency: Currency) {
        context?.let {
            it.startActivity(CurrencyActivity.getStartIntent(it,currency))
        }
    }
}