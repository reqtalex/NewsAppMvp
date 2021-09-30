package com.kreqter.newsappmvp.domain.models

data class UiModel(
    val title: String,
    val url: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?
)
