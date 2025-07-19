package com.aviirajsharma.quotesapp.domain.usecase

import com.aviirajsharma.quotesapp.domain.model.Quote
import com.aviirajsharma.quotesapp.domain.repository.QuoteRepository
import javax.inject.Inject

class DailyQuoteUseCase @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke() : Quote {
        return repository.getQuoteOfTheDay()
    }
}