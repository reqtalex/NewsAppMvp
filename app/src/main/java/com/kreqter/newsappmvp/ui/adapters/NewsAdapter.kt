package com.kreqter.newsappmvp.ui.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kreqter.newsappmvp.domain.models.UiModel

class NewsAdapter(
    private val onNewsItemClickListener: OnNewsItemClickListener
) :
    PagingDataAdapter<UiModel, NewsViewHolder>(UiModelDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.create(parent, onNewsItemClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object UiModelDiffItemCallback : DiffUtil.ItemCallback<UiModel>() {

        override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
            return oldItem.title == newItem.title && oldItem.url == newItem.url
        }
    }
}
