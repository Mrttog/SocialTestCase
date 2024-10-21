package com.example.myapplication.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import com.example.myapplication.R

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    val icon = if (selectedTabIndex == index) item.iconSelected else item.iconUnselected
                    val color = if (selectedTabIndex == index) colorResource(id = R.color.light_blue) else Color.LightGray
                    Icon(imageVector = icon, contentDescription = null, tint = color)
                },
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}

data class BottomNavItem(
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val route: String
)