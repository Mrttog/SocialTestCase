package com.example.myapplication.di

import com.example.myapplication.api.repository.ConversionRepository
import com.example.myapplication.api.repository.DealRepository
import com.example.myapplication.api.room.AppDatabase
import com.example.myapplication.api.room.daos.FavoriteDao
import com.example.myapplication.api.services.ConversionService
import com.example.myapplication.api.services.DealsService
import com.example.myapplication.utils.TrailingCommaInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL_SOCIAL_DEAL = "https://media.socialdeal.nl/"
    private const val BASE_URL_CONVERSION = "https://api.currencyapi.com/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(TrailingCommaInterceptor())
        .build()

    @Provides
    @Singleton
    @BaseUrlSocial
    fun provideSocialDealsRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_SOCIAL_DEAL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @BaseUrlConversion
    fun provideConversionRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_CONVERSION)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDealsApi(
        @BaseUrlSocial retrofit: Retrofit
    ): DealsService {
        return retrofit.create(DealsService::class.java)
    }

    @Provides
    @Singleton
    fun provideConversionApi(
        @BaseUrlConversion retrofit: Retrofit
    ): ConversionService {
        return retrofit.create(ConversionService::class.java)
    }

    @Provides
    @Singleton
    fun provideDealsRepository(
        dealsService: DealsService
    ): DealRepository {
        return DealRepository(dealsService)
    }

    @Provides
    @Singleton
    fun provideConversionRepository(
        conversionService: ConversionService
    ): ConversionRepository {
        return ConversionRepository(conversionService)
    }
}

// Qualifiers for distinguishing between base URLs
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlSocial

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlConversion