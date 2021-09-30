package com.kreqter.newsappmvp.ui.reading

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ReadingView: MvpView {
    fun setupActionBar()
    fun loadWebView()
    fun openWebView()
}