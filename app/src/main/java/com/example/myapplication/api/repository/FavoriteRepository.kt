package com.example.myapplication.api.repository

import com.example.myapplication.api.room.daos.FavoriteDao
import com.example.myapplication.api.room.entities.DealEntity
import com.example.myapplication.data.Deal
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val favoriteDao: FavoriteDao){
    suspend fun addFavorite(deal: DealEntity) {
        favoriteDao.addDealToFavorites(deal)
    }

    suspend fun removeFavorite(deal: DealEntity) {
        favoriteDao.removeDealFromFavorites(deal)
    }

    suspend fun getFavorites(): List<DealEntity> {
        return favoriteDao.getAllFavorites()
    }

}