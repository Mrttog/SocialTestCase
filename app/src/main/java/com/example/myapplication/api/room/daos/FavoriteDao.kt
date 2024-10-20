package com.example.myapplication.api.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.api.room.entities.DealEntity
import com.example.myapplication.data.Deal
import retrofit2.http.GET
import retrofit2.http.HTTP

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDealToFavorites(deal: DealEntity)

    @Delete
    suspend fun removeDealFromFavorites(deal: DealEntity)

    @GET
    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<DealEntity>
}