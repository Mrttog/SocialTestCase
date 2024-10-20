package com.example.myapplication.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.models.DealResponse
import com.example.myapplication.api.repository.ConversionRepository
import com.example.myapplication.api.repository.DealRepository
import com.example.myapplication.api.repository.FavoriteRepository
import com.example.myapplication.api.room.daos.FavoriteDao
import com.example.myapplication.api.room.entities.DealEntity
import com.example.myapplication.data.Deal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DealViewModel @Inject constructor(
    private val dealRepository: DealRepository,
    private val favoriteRepository: FavoriteRepository,
    private val conversionRepository: ConversionRepository
) : ViewModel() {

    var dealsList by mutableStateOf<List<Deal>>(emptyList())
        private set

    var favoriteDealsList by mutableStateOf<List<Deal>>(emptyList())
        private set

    var deal by mutableStateOf<DealResponse?>(null)
        private set

    var conversionRate by mutableStateOf<Double>(1.08)
        private set

    fun getDeals() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                dealRepository.getDeals()
            }
            if (response.isSuccessful) {
                val deals = response.body()?.deals ?: emptyList()
                val favoriteDeals = favoriteRepository.getFavorites()

                favoriteDealsList = favoriteDeals.map { dealEntity ->
                    dealEntity.isFavorite = true
                    dealEntity.toDeal()
                }
                dealsList = deals.map { deal ->
                    deal.copy(isFavorite = favoriteDeals.any { it.unique == deal.unique })
                }
            } else {
                // handle error
            }
        }
    }

    fun getConversionRate() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                conversionRepository.getConversion()
            }
            if (response.isSuccessful) {
                val conversion = response.body()
                conversionRate = conversion?.data?.USD?.value ?: 1.08
            } else {
                // handle error
            }
        }
    }

    fun getDeal(id: String) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                dealRepository.getDeal(id)
            }
            if (response.isSuccessful) {
                deal = response.body()
            } else {
                // handle error
            }
        }
    }

    fun onFavoriteClicked(deal: Deal) {
        viewModelScope.launch {
            if (deal.isFavorite) {
                favoriteRepository.removeFavorite(deal.toDealEntity())
            } else {
                favoriteRepository.addFavorite(deal.toDealEntity())
            }

            getDeals()
        }
    }

    private fun Deal.toDealEntity(): DealEntity {
        return DealEntity(
            unique = unique,
            title = title,
            image = image,
            sold_label = sold_label,
            company = company,
            city = city,
            prices = prices,
            isFavorite = isFavorite
        )
    }

    fun DealEntity.toDeal(): Deal {
        return Deal(
            unique = unique,
            title = title,
            image = image,
            sold_label = sold_label,
            company = company,
            city = city,
            prices = prices,
            isFavorite = isFavorite
        )
    }
}