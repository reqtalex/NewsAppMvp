package com.kreqter.newsappmvp.di

import android.app.Application
import com.kreqter.newsappmvp.data.storage.AppDatabase
import com.kreqter.newsappmvp.data.storage.news.NewsDao
import com.kreqter.newsappmvp.data.storage.remotekey.RemoteKeysDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun provideNewsDao(database: AppDatabase): NewsDao {
        return database.newsDao()
    }

    @Singleton
    @Provides
    fun provideKeysDao(database: AppDatabase):  RemoteKeysDao {
        return database.remoteKeysDao()
    }
}