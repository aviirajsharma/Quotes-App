package com.aviirajsharma.quotesapp.domain.repository

import com.aviirajsharma.quotesapp.domain.model.Quote

//Interface banate hain taaki UI/data layer loosely coupled ho.
//Iska implementation data layer karegi.
//Ye abstraction layer hai.

interface QuoteRepository {
    suspend fun getQuote() : Quote
    suspend fun getQuoteOfTheDay() : Quote
}