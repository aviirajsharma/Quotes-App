package com.aviirajsharma.quotesapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Today
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Quote : BottomNavItem("quote", Icons.Filled.FormatQuote, "Quote")
    object Favorites : BottomNavItem("favorite", Icons.Filled.Favorite, "Favorite")
    object QuoteOfTheDay : BottomNavItem("quote_of_day", Icons.Filled.Today, "Quote Of Day")
}