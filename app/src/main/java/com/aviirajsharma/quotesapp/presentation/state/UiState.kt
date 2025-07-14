package com.aviirajsharma.quotesapp.presentation.state

import com.aviirajsharma.quotesapp.domain.model.Quote

//ViewModel ke state ko define karta hai: Loading, Success, Error.
//UI easily respond kar sakta hai current state ke hisaab se.

sealed class UiState {
    object Loading : UiState()
    data class Success(val quote: Quote) : UiState()
    data class Error(val message: String) : UiState()
}