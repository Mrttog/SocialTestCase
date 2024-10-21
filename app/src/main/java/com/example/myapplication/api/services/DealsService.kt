package com.example.myapplication.api.services

import com.example.myapplication.api.models.DealResponse
import com.example.myapplication.api.models.DealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DealsService {
    @GET("demo/deals.json")
    suspend fun getDeals(): Response<DealsResponse>

    @GET("demo/details.json")
    // call with query id
    suspend fun getDeal(@Query("id") id: String): Response<DealResponse>
}