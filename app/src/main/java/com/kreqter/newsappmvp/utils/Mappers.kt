package com.kreqter.newsappmvp.utils

import android.text.format.DateUtils
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_DESC_SIZE
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_TITLE_SIZE
import com.kreqter.newsappmvp.data.remote.models.ArticleDto
import com.kreqter.newsappmvp.data.storage.news.NewsEntity
import com.kreqter.newsappmvp.domain.models.UiModel
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
internal fun ArticleDto.toEntity(): NewsEntity {
    return NewsEntity(
        title = if (title.length > DEFAULT_TITLE_SIZE) {
            title.substring(0, DEFAULT_TITLE_SIZE).plus("...")
        }
        else {
            title
        },
        url = url,
        description = if (description?.length!! > DEFAULT_DESC_SIZE) {
            description.substring(0, DEFAULT_DESC_SIZE).plus("...")
        }
        else {
            description
        },
        urlToImage = urlToImage,
        publishedAt = DateUtils.getRelativeTimeSpanString(publishedAt.time) as String?
    )
}

internal fun NewsEntity.toUiModel(): UiModel {
    return UiModel(
        title = title,
        url = url,
        description = description,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )
}