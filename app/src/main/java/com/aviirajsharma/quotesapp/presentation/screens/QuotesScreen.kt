package com.aviirajsharma.quotesapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aviirajsharma.quotesapp.presentation.composables.QuoteCard
import com.aviirajsharma.quotesapp.presentation.state.UiState
import com.aviirajsharma.quotesapp.presentation.viewmodel.QuoteViewModel


//Jetpack Compose ka screen hai.
//ViewModel se state observe karta hai aur UI show karta hai.

@Composable
fun QuotesScreen(viewModel: QuoteViewModel = hiltViewModel()) {
    val state by viewModel.quoteState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getQuote()
    }

    when (state) {
        is UiState.Loading -> Text("Loading...")
        is UiState.Success -> {
            val quote = (state as UiState.Success).quote
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuoteCard(quote = quote)
            }

        }

        is UiState.Error -> Text("Error: ${(state as UiState.Error).message}")
    }
}