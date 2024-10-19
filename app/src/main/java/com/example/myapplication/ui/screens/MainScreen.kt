package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.data.Deal
import com.example.myapplication.ui.components.BottomNavItem
import com.example.myapplication.ui.components.BottomNavigationBar

@Composable
fun MainScreen(deals: List<Deal>) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val items = listOf(
        BottomNavItem(
            iconSelected = Icons.Filled.Home,
            iconUnselected = Icons.Outlined.Home,
            route = "home"
        ),
        BottomNavItem(
            iconSelected = Icons.Filled.Favorite,
            iconUnselected = Icons.Outlined.FavoriteBorder,
            route = "favorites"
        ),
        BottomNavItem(
            iconSelected = Icons.Filled.Settings,
            iconUnselected = Icons.Outlined.Settings,
            route = "settings"
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = items,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            when (selectedTabIndex) {
                0 -> HomeScreen(deals = deals)
                1 -> FavoriteScreen()
                2 -> SettingsScreen()
            }
        }
    }
}