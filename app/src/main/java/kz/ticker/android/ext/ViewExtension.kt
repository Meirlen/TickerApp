package kz.ticker.android.ext


import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kz.ticker.android.base.CurrencyType
import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*


fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}



fun TextView.showPrice(currency: String = CurrencyType.USD.name, price: Double) {

    val builder = StringBuilder()
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance(currency.toUpperCase())
    val res = numberFormat.format(price)
    builder.append(res)

    text = builder.toString()

}


