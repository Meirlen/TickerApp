package kz.atf24.bank.base.recycler

interface OnItemClickListener {

    fun onHeaderClicked() {

    }

    fun onItemClicked(position: Int)

    fun onFooterClicked() {

    }
}