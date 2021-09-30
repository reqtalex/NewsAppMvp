package com.kreqter.newsappmvp.ui.reading

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ReadingPresenter : MvpPresenter<ReadingView>() {
    fun setUpReading() {
        viewState.setupActionBar()
        viewState.loadWebView()
        viewState.openWebView()
    }
}