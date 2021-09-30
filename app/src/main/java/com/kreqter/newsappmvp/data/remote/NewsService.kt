package com.kreqter.newsappmvp.data.remote

import com.kreqter.newsappmvp.data.remote.models.ArticlesResponseDto
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_PAGE_SIZE
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_QUERY
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NewsService {

    @ExperimentalSerializationApi
    @GET("/v2/everything")
    suspend fun everything(
        @Query("q") query: String = DEFAULT_QUERY,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = DEFAULT_PAGE_SIZE,
        @Query("from") from: Date? = null,
        @Query("sortBy") sortBy: SortBy = SortBy.publishedAt,
    ): Response<ArticlesResponseDto>

    enum class SortBy {
        relevancy,
        popularity,
        publishedAt
    }

}