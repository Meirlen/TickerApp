package kz.ticker.android.ui.ticket

import android.content.Context
import android.view.View
import com.example.gateway.entity.Currency
import kz.ticker.android.base.BaseRecyclerAdapter
import kz.ticker.android.base.OnItemClickListener


open class TickerAdapter(
    dataList: List<Currency>,onItemClickListener: OnItemClickListener
) :
    BaseRecyclerAdapter<Currency>(dataList,onItemClickListener) {

    init {
        withHeader = true
    }

    override fun getItemView(context: Context, viewType: Int): View {
        return TickerItem(context)
    }

    override fun getHeaderView(context: Context): View? {
        return TickerHeaderItem(context)
    }

    override fun bindData(itemView: View, data: Currency, position: Int) {
        if (itemView is TickerItem) {
            itemView.setData(data)
        }
    }

    override fun bindHeaderData(itemView: View, position: Int) {
        if (itemView is TickerHeaderItem) {
            itemView.setListSize(dataList.size)
        }
    }

}