package kz.ticker.android.ext


import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kz.ticker.android.base.CurrencyType
import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*


val Context.networkInfo: NetworkInfo? get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo


fun TextView.showPrice(currency: String = CurrencyType.USD.name, price: Double) {

    val builder = StringBuilder()
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance(currency.toUpperCase())
    val res = numberFormat.format(price)
    builder.append(res)

    text = builder.toString()

}


