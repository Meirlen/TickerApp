package kz.ticker.android.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import com.example.gateway.entity.Currency
import kotlinx.android.synthetic.main.view_currency.view.*
import kz.ticker.android.R


class CurrencyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        View.inflate(context, R.layout.view_currency, this)
    }

    fun setData(currency: Currency) {
        titleTv.text = currency.name
        descTv.text = currency.symbol
    }

}