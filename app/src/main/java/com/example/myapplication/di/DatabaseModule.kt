package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.SocialDealApplication
import com.example.myapplication.api.room.AppDatabase
import com.example.myapplication.api.room.daos.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "deals_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideFavoriteDao(database: AppDatabase): FavoriteDao {
        return database.dealDao()
    }
}