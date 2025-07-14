package com.aviirajsharma.quotesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aviirajsharma.quotesapp.domain.usecase.GetQuoteUseCase
import com.aviirajsharma.quotesapp.presentation.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel app ke logic ko hold karta hai.
//UI state yahi control karta hai.
//UseCase se quote fetch karta hai.


@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase: GetQuoteUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state


    init {
        getQuote()
    }

    private fun getQuote() {
        viewModelScope.launch {
            try {
                val quote = getQuoteUseCase()
                _state.value = UiState.Success(quote)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.localizedMessage ?: "Error Occurred")
            }
        }
    }

}