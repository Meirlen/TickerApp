package kz.ticker.android.custom

import android.content.Context
import androidx.appcompat.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.view_base_toolbar.view.*
import kz.ticker.android.R

class CenteredTitleToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_base_toolbar, this)
    }

    fun setToolbarPram(title: String) {
        toolbarTitle.text = title
    }
}