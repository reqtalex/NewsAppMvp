package com.kreqter.newsappmvp.data.remote.models

import androidx.annotation.IntRange
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class ArticlesResponseDto(
    @SerialName("status") val status: String,
    @SerialName("totalResults") @IntRange(from = 1) val totalResults: Int,
    @SerialName("message") val message: String? = null,
    @SerialName("articles") val articles: List<ArticleDto>,
)
