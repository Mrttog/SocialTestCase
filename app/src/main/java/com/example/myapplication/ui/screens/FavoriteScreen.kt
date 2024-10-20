package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Deal
import com.example.myapplication.ui.components.DealItem

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteDeals: List<Deal>,
    onDealClicked: (String) -> Unit,
    onFavoriteClicked: (Deal) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = favoriteDeals
        ) { deal ->
            DealItem(
                deal = deal,
                onFavoriteClicked = { onFavoriteClicked(deal) },
                modifier = Modifier.clickable {
                    onDealClicked(deal.unique)
                })
        }
    }
}