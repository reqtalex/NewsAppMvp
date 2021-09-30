package com.kreqter.newsappmvp.ui.splash

import android.widget.ImageView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SplashScreenPresenter : MvpPresenter<SplashScreenView>() {
    fun splashing(imageView: ImageView) {
        viewState.startSplash(imageView)
    }
}