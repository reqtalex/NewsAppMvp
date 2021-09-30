package com.kreqter.newsappmvp.ui.reading

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kreqter.newsappmvp.R
import com.kreqter.newsappmvp.databinding.ActivityReadingBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class ReadingActivity : MvpAppCompatActivity(R.layout.activity_reading), ReadingView {

    private val readingPresenter by moxyPresenter { ReadingPresenter() }
    private val viewBinding by viewBinding(ActivityReadingBinding::bind)

    companion object {
        const val URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readingPresenter.setUpReading()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //View implementation
    override fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.reading)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun loadWebView() {
        with(viewBinding) {
            pbProgressBar.visibility = View.VISIBLE
            wvWeb.visibility = View.GONE
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun openWebView() {
        val url = intent.getStringExtra(URL)
        with(viewBinding) {
            wvWeb.webViewClient = WebViewClient()
            wvWeb.apply {
                if (url != null) {
                    loadUrl(url)
                }
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
            pbProgressBar.visibility = View.GONE
            wvWeb.visibility = View.VISIBLE
        }
    }
}