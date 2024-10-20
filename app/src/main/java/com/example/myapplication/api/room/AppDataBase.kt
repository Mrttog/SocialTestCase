package com.example.myapplication.api.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.api.room.daos.FavoriteDao
import com.example.myapplication.api.room.entities.DealEntity
import com.example.myapplication.utils.RoomTypeConverters

@Database(entities = [DealEntity::class], version = 1)
@TypeConverters(RoomTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dealDao(): FavoriteDao

}