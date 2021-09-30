package com.kreqter.newsappmvp.domain.repository

import androidx.paging.*
import androidx.room.withTransaction
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_PAGE_SIZE
import com.kreqter.newsappmvp.Constants.Companion.DEFAULT_PREFETCH
import com.kreqter.newsappmvp.Constants.Companion.INITIAL_LOAD_SIZE
import com.kreqter.newsappmvp.data.paging.RemoteMediator
import com.kreqter.newsappmvp.data.remote.NewsService
import com.kreqter.newsappmvp.data.storage.AppDatabase
import com.kreqter.newsappmvp.domain.models.UiModel
import com.kreqter.newsappmvp.utils.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService,
    private val appDatabase: AppDatabase
) {

    @ExperimentalPagingApi
    fun getNewsFromMediator(): Flow<PagingData<UiModel>> {
        val pagingSourceFactory = { appDatabase.newsDao().pagingSource() }
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE_SIZE,
                initialLoadSize = INITIAL_LOAD_SIZE,
                maxSize = DEFAULT_PREFETCH * 2 + DEFAULT_PAGE_SIZE,
                prefetchDistance = DEFAULT_PREFETCH,
                enablePlaceholders = true
            ),
            remoteMediator = RemoteMediator(appDatabase, newsService),
            pagingSourceFactory = pagingSourceFactory
        ).flow
            .map { pagingData ->
                pagingData.map { it.toUiModel() }
            }
    }

    suspend fun databaseIsEmpty(): Boolean =
        appDatabase.withTransaction { appDatabase.newsDao().getNewsList().isEmpty() }
}