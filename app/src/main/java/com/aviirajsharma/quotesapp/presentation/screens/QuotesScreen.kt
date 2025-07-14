package com.aviirajsharma.quotesapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aviirajsharma.quotesapp.presentation.state.UiState
import com.aviirajsharma.quotesapp.presentation.viewmodel.QuoteViewModel


//Jetpack Compose ka screen hai.
//ViewModel se state observe karta hai aur UI show karta hai.

@Composable
fun QuotesScreen(viewModel: QuoteViewModel = hiltViewModel()){
    val state by viewModel.state.collectAsState()

    when(state){
        is UiState.Loading -> Text("Loading...")
        is UiState.Success -> {
            val quote = (state as UiState.Success).quote
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = quote.quote)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "-${quote.author}")
            }
        }
        is UiState.Error -> Text("Error: ${(state as UiState.Error).message}")
    }
}