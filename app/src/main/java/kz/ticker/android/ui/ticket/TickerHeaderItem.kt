package kz.ticker.android.ui.ticket

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import kotlinx.android.synthetic.main.item_header.view.*
import kz.ticker.android.R


class TickerHeaderItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        setBackgroundColor(context.resources.getColor(R.color.black))
        View.inflate(context, R.layout.item_header, this)
    }

    fun setListSize(size: Int) {
        listSizeTv.text = size.toString()
    }

}