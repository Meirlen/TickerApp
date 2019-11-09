package kz.ticker.android.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.gateway.entity.Currency
import kotlinx.android.synthetic.main.activity_currency.*
import kz.ticker.android.R

import kz.ticker.android.base.BaseActivity
import kz.ticker.android.ext.replaceOnce


class CurrencyActivity : BaseActivity() {


    companion object {
        const val EXTRA_CURRENCY = "EXTRA_CURRENCY"


        fun getStartIntent(context: Context, currency: Currency): Intent {
            val intent = Intent(context, CurrencyActivity::class.java)
            intent.putExtra(EXTRA_CURRENCY, currency)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        showCurrency()
    }

    private fun showCurrency() {
        getExtraCurrency()?.let {
            currencyView.setData(it)
            mToolBar.setToolbarPram(it.name ?: getString(R.string.currency_activity_title))

        }
    }

    private fun getExtraCurrency() = intent.getParcelableExtra<Currency>(EXTRA_CURRENCY)

}
