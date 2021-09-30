package com.kreqter.newsappmvp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.kreqter.newsappmvp.R
import com.kreqter.newsappmvp.databinding.ItemErrorBinding

class NewsLoadStateViewHolder(
    binding: ItemErrorBinding,
    retry: () -> Unit,
    private val connected: Boolean
) : RecyclerView.ViewHolder(binding.root) {

    private val viewBinding by viewBinding(ItemErrorBinding::bind)

    init {
        viewBinding.card.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        with(viewBinding)
        {
            if (loadState is LoadState.Error) {
                if (connected) {
                    tvError.setText(R.string.error)
                    ivNetwork.load(R.drawable.error)
                } else {
                    ivNetwork.load(R.drawable.disconnected)
                    tvError.text = loadState.error.localizedMessage
                }
            }
            pbProgressBar.isVisible = loadState is LoadState.Loading
            card.isVisible = loadState is LoadState.Error
        }
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit, connected: Boolean): NewsLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_error, parent, false)
            val binding = ItemErrorBinding.bind(view)
            return NewsLoadStateViewHolder(binding, retry, connected)
        }
    }
}