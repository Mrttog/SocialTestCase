package com.example.myapplication.api.repository

import com.example.myapplication.api.services.DealsService
import com.example.myapplication.di.BaseUrlSocial
import javax.inject.Inject

class DealRepository @Inject constructor(
    @BaseUrlSocial private val dealsService: DealsService
) {
    suspend fun getDeals() = dealsService.getDeals()
    suspend fun getDeal(id: String) = dealsService.getDeal()
}