package com.example.myapplication.ui.screens

import android.annotation.SuppressLint
import android.text.Html
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.R
import com.example.myapplication.data.Currency
import com.example.myapplication.data.Deal
import com.example.myapplication.data.Price
import com.example.myapplication.ui.components.DealItem
import com.example.myapplication.ui.viewmodels.DealViewModel
import com.example.myapplication.utils.PreferencesManager
import com.example.myapplication.utils.UtilPrice

@Composable
fun ItemScreen(
    deal: Deal,
    modifier: Modifier = Modifier,
    dealViewModel: DealViewModel,
    preferencesManager: PreferencesManager,
) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            val currency = preferencesManager.getCurrencyPreference()

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
                onFavoriteClicked = { dealViewModel.onFavoriteClicked(deal) }
            )

            deal.description?.let { htmlDescription ->
                HtmlText(html = htmlDescription)
            }
        }
}

@SuppressLint("NewApi")
@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    // Use AndroidView to render HTML
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY) // Render HTML content
            }
        },
        update = {
            it.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY) // Update if needed
        },
        modifier = modifier.padding(16.dp)
    )
}