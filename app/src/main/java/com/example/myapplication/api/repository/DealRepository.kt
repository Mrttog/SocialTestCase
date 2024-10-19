package com.example.myapplication.api.repository

import com.example.myapplication.api.services.DealsService
import javax.inject.Inject

class DealRepository @Inject constructor(
    private val dealsService: DealsService
) {
    suspend fun getDeals() = dealsService.getDeals()
}