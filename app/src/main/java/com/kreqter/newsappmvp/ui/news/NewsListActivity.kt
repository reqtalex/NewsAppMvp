package com.kreqter.newsappmvp.ui.news

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.kreqter.newsappmvp.R
import com.kreqter.newsappmvp.appComponent
import com.kreqter.newsappmvp.databinding.ActivityNewsListBinding
import com.kreqter.newsappmvp.ui.reading.ReadingActivity
import com.kreqter.newsappmvp.ui.adapters.NewsAdapter
import com.kreqter.newsappmvp.ui.adapters.NewsLoadStateAdapter
import com.kreqter.newsappmvp.ui.adapters.OnNewsItemClickListener
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class NewsListActivity : MvpAppCompatActivity(R.layout.activity_news_list), NewsListView,
    OnNewsItemClickListener {

    @Inject
    lateinit var presenterProvider: Provider<NewsListPresenter>
    private val newsListPresenter by moxyPresenter { presenterProvider.get() }

    private val viewBindingActivity by viewBinding(ActivityNewsListBinding::bind)
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        NewsAdapter(this)
    }

    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        val context = this
        lifecycleScope.launch {
            newsListPresenter.setUpAdapter(context)
            newsListPresenter.pagingNews.collectLatest { data ->
                adapter.submitData(data)
            }
        }
    }

    //NewsListView implementation
    override fun initAdapter(connected: Boolean, empty: Boolean) {
        with(viewBindingActivity) {

            rvRecyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = NewsLoadStateAdapter({ adapter.retry() }, connected),
                footer = NewsLoadStateAdapter({ adapter.retry() }, connected)
            )
            adapter.addLoadStateListener { state ->
                if (connected) {
                    tvError.setText(R.string.error)
                    ivNetwork.load(R.drawable.error)
                } else {
                    tvError.setText(R.string.disconnect)
                    ivNetwork.load(R.drawable.disconnected)
                }
                card.isVisible = state.mediator?.refresh is LoadState.Error && empty
                rvRecyclerView.isVisible = state.mediator?.refresh !is LoadState.Loading
                pbProgressBar.isVisible = state.mediator?.refresh is LoadState.Loading
            }
            card.setOnClickListener {
                adapter.retry()
            }
        }
    }

    //OnNewsItemClickListener implementation
    override fun onItemClick(url: String) {
        val intent = Intent(this, ReadingActivity::class.java)
        intent.putExtra(ReadingActivity.URL, url)
        startActivity(intent)
    }

}