package com.example.myapplication.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.repository.DealRepository
import com.example.myapplication.data.Deal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DealViewModel @Inject constructor(private val repository: DealRepository) : ViewModel() {

    var deals by mutableStateOf<List<Deal>>(emptyList())
        private set

    fun getDeals() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getDeals()
            }
            Log.d("tigo", "response: ${response.body()}")
            if (response.isSuccessful) {
                deals = response.body()?.deals ?: emptyList()
                Log.d("tigo", "deals: ${deals.size}")
            } else {
                // handle error
            }
        }
    }
}