package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.Currency
import com.example.myapplication.data.Deal
import com.example.myapplication.data.Price
import com.example.myapplication.ui.components.DealItem
import com.example.myapplication.ui.viewmodels.DealViewModel
import com.example.myapplication.utils.UtilPrice

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteDeals: List<Deal>,
    dealViewModel: DealViewModel,
    currency: Boolean,
    onDealClicked: (String) -> Unit,
    onFavoriteClicked: (Deal) -> Unit
) {
    if (favoriteDeals.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.no_favorite_deals_yet)
            )
        }

    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(
                items = favoriteDeals
            ) { deal ->
                val formattedPrice = UtilPrice.convertPrice(
                    deal.prices.price?.amount ?: 0.0,
                    currency,
                    dealViewModel.conversionRate
                )
                val formattedFromPrice = UtilPrice.convertPrice(
                    deal.prices.fromPrice?.amount ?: 0.0,
                    currency,
                    dealViewModel.conversionRate
                )
                DealItem(
                    deal = deal.copy(
                        prices = deal.prices.copy(
                            price = Price(
                                amount = formattedPrice,
                                currency = Currency(
                                    symbol = if (currency) "$" else "€",
                                    code = if (currency) stringResource(R.string.usd) else stringResource(R.string.eur)
                                )
                            ),
                            fromPrice = Price(
                                amount = formattedFromPrice,
                                currency = Currency(
                                    symbol = if (currency) "$" else "€",
                                    code = if (currency) stringResource(R.string.usd) else stringResource(R.string.eur)
                                )
                            )
                        )
                    ),
                    onFavoriteClicked = { onFavoriteClicked(deal) },
                    modifier = Modifier.clickable {
                        onDealClicked(deal.unique)
                    })
            }
        }
    }
}