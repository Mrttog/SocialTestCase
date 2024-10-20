package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.viewmodels.DealViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.ui.screens.ItemScreen
import com.example.myapplication.utils.PreferencesManager
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = MainScreen
            ) {

                composable<MainScreen> {
                    val dealsViewModel: DealViewModel = hiltViewModel()
                    LaunchedEffect(Unit) {
                        dealsViewModel.getConversionRate()
                        dealsViewModel.getDeals()
                    }
                    MainScreen(
                        dealViewModel = dealsViewModel,
                        preferenceManager = PreferencesManager(this@MainActivity),
                        onDealClicked = {
                            navController.navigate(DetailScreen(it))
                        })
                }

                composable<DetailScreen> {
                    val args = it.toRoute<DetailScreen>()
                    val dealsViewModel: DealViewModel = hiltViewModel()
                    LaunchedEffect(Unit) {
                        dealsViewModel.getDeal(args.dealId)
                    }
                    ItemScreen(dealsViewModel.deal)
                }
            }
        }
    }
}

@Serializable
object MainScreen

@Serializable
data class DetailScreen(val dealId: String)