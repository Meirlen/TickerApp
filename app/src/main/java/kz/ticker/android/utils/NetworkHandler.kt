package kz.ticker.android.utils

import android.content.Context
import kz.ticker.android.ext.networkInfo

class NetworkHandler(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting ?: true
}