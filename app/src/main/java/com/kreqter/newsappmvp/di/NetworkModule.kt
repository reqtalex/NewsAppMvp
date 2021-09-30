package com.kreqter.newsappmvp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kreqter.newsappmvp.data.remote.AuthInterceptor
import com.kreqter.newsappmvp.data.remote.NewsService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json(Json) {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideNewsService(json: Json): NewsService {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(com.kreqter.newsappmvp.BuildConfig.API_KEY))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(httpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create(NewsService::class.java)
    }
}