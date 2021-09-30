package com.kreqter.newsappmvp.ui.adapters

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class NewsLoadStateAdapter(
    private val retry: () -> Unit,
    private val connected: Boolean
) : LoadStateAdapter<NewsLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: NewsLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): NewsLoadStateViewHolder {
        return NewsLoadStateViewHolder.create(parent, retry, connected)
    }
}