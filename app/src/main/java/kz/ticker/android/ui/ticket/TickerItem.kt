package kz.ticker.android.ui.ticket

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import com.example.gateway.entity.Currency
import kotlinx.android.synthetic.main.item_ticker.view.*
import kz.ticker.android.R


class TickerItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        View.inflate(context, R.layout.item_ticker, this)
    }

    fun setData(currency: Currency) {
        titleTv.text = currency.name
        descTv.text = currency.symbol
    }

}