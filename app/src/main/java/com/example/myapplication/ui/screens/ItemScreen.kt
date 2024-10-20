package com.example.myapplication.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.api.models.DealResponse

@Composable
fun ItemScreen(deal: DealResponse?) {
    Text (
        text = deal?.description ?: "No Deal found"
    )
}