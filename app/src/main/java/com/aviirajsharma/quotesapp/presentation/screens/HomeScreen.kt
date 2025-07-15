package com.aviirajsharma.quotesapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aviirajsharma.quotesapp.presentation.composables.BottomNavigationBar
import com.aviirajsharma.quotesapp.presentation.composables.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar("Quotes App") },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "quote",
            modifier = Modifier.padding(innerPadding)
        ){
            composable("quote") {
                QuotesScreen()
            }
            composable("favorite") {
                FavoriteScreen()
            }
            composable("quote_of_day") {
                QuoteOfTheDayScreen()
            }
        }
    }
}




