package com.aviirajsharma.quotesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aviirajsharma.quotesapp.domain.model.Quote
import com.aviirajsharma.quotesapp.domain.usecase.DailyQuoteUseCase
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
    private val getQuoteUseCase: GetQuoteUseCase,
    private val getDailyQuoteUseCase: DailyQuoteUseCase
) : ViewModel() {

    private val _quoteState = MutableStateFlow<UiState>(UiState.Loading)
    val quoteState: StateFlow<UiState> = _quoteState

    private val _dailyQuoteState = MutableStateFlow<UiState>(UiState.Loading)
    val dailyQuoteState: StateFlow<UiState> = _dailyQuoteState

    // ✅ Caching the result to avoid API hitting again and again
    private var quoteCache: Quote? = null
    private var dailyQuoteCache: Quote? = null

    fun getQuote() {
        // ✅ Check if quote is already fetched
        if (quoteCache != null) {
            _quoteState.value = UiState.Success(quoteCache!!)
            return
        }

        viewModelScope.launch {
            _quoteState.value = UiState.Loading
            try {
                val quote = getQuoteUseCase()
                quoteCache = quote
                _quoteState.value = UiState.Success(quote)
            } catch (e: Exception) {
                _quoteState.value = UiState.Error(e.localizedMessage ?: "Error occurred")
            }
        }
    }

    fun getDailyQuote() {
        // ✅ Check if daily quote is already fetched
        if (dailyQuoteCache != null) {
            _dailyQuoteState.value = UiState.Success(dailyQuoteCache!!)
            return
        }

        viewModelScope.launch {
            _dailyQuoteState.value = UiState.Loading
            try {
                val quote = getDailyQuoteUseCase()
                dailyQuoteCache = quote
                _dailyQuoteState.value = UiState.Success(quote)
            } catch (e: Exception) {
                _dailyQuoteState.value = UiState.Error(e.localizedMessage ?: "Error occurred")
            }
        }
    }
}
