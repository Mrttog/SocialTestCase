package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.utils.PreferencesManager

@Composable
fun SettingsScreen(preferencesManager: PreferencesManager) {
    var isDollar by remember { mutableStateOf(preferencesManager.getCurrencyPreference()) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "EUR")
        Switch(
            checked = isDollar,
            onCheckedChange = {
                isDollar = it
                preferencesManager.saveCurrencyPreference(isDollar) // Save preference
            }
        )
        Text(text = "USD")
    }
}