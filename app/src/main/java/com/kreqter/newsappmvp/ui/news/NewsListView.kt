package com.kreqter.newsappmvp.ui.news

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface NewsListView : MvpView {
    fun initAdapter(connected: Boolean, empty: Boolean)
}