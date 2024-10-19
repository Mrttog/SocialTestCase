package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.api.services.DealsService
import com.example.myapplication.data.Currency
import com.example.myapplication.data.Deal
import com.example.myapplication.data.Price
import com.example.myapplication.data.Prices
import com.example.myapplication.ui.components.DealItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier, deals: List<Deal>) {
//    val deals = mutableListOf<Deal>()
//    for (i in 1..20) {
//        deals.add(
//            Deal(
//                unique = "1",
//                title = "Deal 1",
//                image = "https://images.socialdeal.nl/deal/corendon-village-hotel-amsterdam-22113009143271.jpg",
//                soldLabel = "Sold 1",
//                company = "Company 1",
//                city = "City 1",
//                prices = Prices(
//                    price = Price(
//                        amount = 1000,
//                        currency = Currency(
//                            code = "USD",
//                            symbol = "$"
//                        )
//                    ),
//                    from_price = Price(
//                        amount = 1000,
//                        currency = Currency(
//                            code = "USD",
//                            symbol = "$"
//                        )
//                    ),
//                    null,
//                    null
//                )
//            )
//        )
//    }

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = deals
        ) { deal ->
            DealItem(deal = deal)
        }
    }
}