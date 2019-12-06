package kz.ticker.android.ui.ticket

import android.content.Context
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TickerItemTest {


    private lateinit var tickerItem: TickerItem
    private lateinit var context: Context


    @Before
    fun setUp() {
        context = RuntimeEnvironment.application.baseContext
        tickerItem = TickerItem(context)
    }

    @Test
    fun setData() {
        tickerItem.setTitle()

    }
}