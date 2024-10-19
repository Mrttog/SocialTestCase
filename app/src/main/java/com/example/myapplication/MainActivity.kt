package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.viewmodels.DealViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dealsViewModel: DealViewModel = hiltViewModel()
            LaunchedEffect(Unit) {
                dealsViewModel.getDeals()
            }
            MainScreen(dealsViewModel.deals)
        }
    }
}