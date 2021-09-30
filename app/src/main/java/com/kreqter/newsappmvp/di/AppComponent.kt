package com.kreqter.newsappmvp.di

import android.app.Application
import com.kreqter.newsappmvp.ui.news.NewsListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(newsListActivity: NewsListActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun create(): AppComponent
    }
}