package com.kreqter.newsappmvp.ui.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.kreqter.newsappmvp.R
import com.kreqter.newsappmvp.databinding.ItemNewsBinding
import com.kreqter.newsappmvp.domain.models.UiModel

class NewsViewHolder(
    binding: ItemNewsBinding,
    private val listener: OnNewsItemClickListener
) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private val viewBinding by viewBinding(ItemNewsBinding::bind)
    private lateinit var urlToArticle: String

    fun bind(item: UiModel?) {
        with(viewBinding)
        {
            urlToArticle = item?.url.toString()
            if (item?.urlToImage != null) {
                ivImage.load(item.urlToImage) {
                    placeholder(ColorDrawable(Color.TRANSPARENT))
                }
            } else ivImage.load(R.drawable.ic_launcher_foreground)
            tvTitle.text = item?.title
            tvDate.text = item?.publishedAt
            tvDescription.text = item?.description
        }
    }

    companion object {
        fun create(view: ViewGroup, listener: OnNewsItemClickListener): NewsViewHolder {
            val inflater = LayoutInflater.from(view.context)
            val binding = ItemNewsBinding.inflate(inflater, view, false)
            return NewsViewHolder(binding, listener)
        }
    }

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        listener.onItemClick(urlToArticle)
    }
}