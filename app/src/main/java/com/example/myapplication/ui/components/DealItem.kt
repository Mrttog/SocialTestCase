package com.example.myapplication.ui.components

import android.content.res.Resources.Theme
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil3.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.utils.UtilPrice.toFormattedPrice
import com.example.myapplication.data.Deal
import com.example.myapplication.utils.UtilImage.addPrefix


@Composable
fun DealItem(
    deal: Deal,
    modifier: Modifier = Modifier,
    onFavoriteClicked: () -> Unit
) {

    val lightBlue = Color(ContextCompat.getColor(LocalContext.current, R.color.light_blue))
    val lightGray = Color(ContextCompat.getColor(LocalContext.current, R.color.light_gray))
    val green = Color(ContextCompat.getColor(LocalContext.current, R.color.green))

    Column(modifier.padding(16.dp)) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = 0.dp
        ) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(deal.image.addPrefix()),
                    contentDescription = deal.title,
                    modifier = modifier.fillMaxWidth()
                )
                IconButton(
                    onClick = {
                        onFavoriteClicked()
                    },
                    modifier = modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = if (deal.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        tint = if (deal.isFavorite) Color.Red else Color.White,
                        contentDescription = null,
                    )
                }
            }
        }

        Spacer(modifier = modifier.height(8.dp))

        Text(
            text = deal.title,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 4.dp)
        )

        Text(
            text = deal.company,
            style = MaterialTheme.typography.body2,
            color = lightGray
        )

        Text(
            text = deal.city,
            style = MaterialTheme.typography.body2,
            color = lightGray,
            modifier = modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = deal.sold_label,
                style = MaterialTheme.typography.body2,
                color = lightBlue
            )
            Row {

                if (deal.prices.from_price != null) {
                    Text(
                        text = deal.prices.from_price.currency.symbol,
                        style = MaterialTheme.typography.subtitle2,
                        color = lightGray,
                        textDecoration = TextDecoration.LineThrough
                    )

                    Text(
                        text = deal.prices.from_price.amount.toFormattedPrice(),
                        style = MaterialTheme.typography.subtitle2,
                        color = lightGray,
                        modifier = modifier.padding(end = 8.dp),
                        textDecoration = TextDecoration.LineThrough
                    )
                }

                Text(
                    text = deal.prices.price?.currency?.symbol ?: "",
                    style = MaterialTheme.typography.subtitle1,
                    color = green
                )

                Text(
                    text = deal.prices.price?.amount?.toFormattedPrice() ?: "Gratis",
                    style = MaterialTheme.typography.h6,
                    color = green
                )
            }
        }
    }

    Divider(
        color = lightGray,
        thickness = 0.5.dp,
        modifier = modifier.padding(top = 4.dp)
    )
}