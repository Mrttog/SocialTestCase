package com.example.myapplication.di

import com.example.myapplication.api.room.AppDatabase
import com.example.myapplication.api.room.daos.FavoriteDao
import com.example.myapplication.api.services.DealsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://media.socialdeal.nl/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDealsApi(retrofit: Retrofit): DealsService {
        return retrofit.create(DealsService::class.java)
    }

}