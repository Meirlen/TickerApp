package kz.ticker.android.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_currency.*
import kz.ticker.android.R

import kz.ticker.android.base.BaseActivity
import kz.ticker.android.ext.replaceOnce


class CurrencyActivity : BaseActivity() {


    companion object {
        const val CURRENCY_FRAGMENT = 0

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, CurrencyActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        mToolBar.setToolbarPram(getString(R.string.currency_activity_title))
        switchFragment()
    }

    private fun switchFragment() {
        supportFragmentManager.replaceOnce(R.id.frame_container, CURRENCY_FRAGMENT.toString(), {
            CurrencyFragment.newInstance()
        }).commit()
    }

}
