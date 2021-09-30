package com.kreqter.newsappmvp.ui.splash

import android.widget.ImageView
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SplashScreenView : MvpView {
    fun startSplash(Image: ImageView)
}