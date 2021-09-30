package com.kreqter.newsappmvp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kreqter.newsappmvp.R
import com.kreqter.newsappmvp.databinding.ActivitySplashScreenBinding
import com.kreqter.newsappmvp.ui.news.NewsListActivity
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class SplashScreenActivity : MvpAppCompatActivity(R.layout.activity_splash_screen),
    SplashScreenView {

    private val splashScreenPresenter by moxyPresenter { SplashScreenPresenter() }
    private val viewBinding by viewBinding(ActivitySplashScreenBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(viewBinding) {
            splashScreenPresenter.splashing(ivCat)
        }
    }

    //View implementation
    override fun startSplash(image: ImageView) {
        image.alpha = 0f
        image.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, NewsListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}