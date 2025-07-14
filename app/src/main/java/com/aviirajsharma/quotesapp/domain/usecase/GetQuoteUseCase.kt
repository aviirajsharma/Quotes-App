package com.aviirajsharma.quotesapp.domain.usecase

import com.aviirajsharma.quotesapp.domain.model.Quote
import com.aviirajsharma.quotesapp.domain.repository.QuoteRepository

//Ek use case = ek kaam, yaha "Get one random quote".
//Pure logic yaha hota hai.
//ViewModel sirf usecase call karta hai — neat separation.


class GetQuoteUseCase(private val repository: QuoteRepository) {
    suspend operator fun invoke() : Quote{
        return repository.getQuote()
    }
}