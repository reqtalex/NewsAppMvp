package com.kreqter.newsappmvp.data.storage.news

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<NewsEntity>)

    @Query("SELECT * FROM cacheNews")
    fun pagingSource(): PagingSource<Int, NewsEntity>

    @Query("DELETE FROM cacheNews")
    suspend fun clearAll()

    @Query("SELECT * FROM cacheNews")
    fun getNewsList(): List<NewsEntity>
}