package com.aviirajsharma.quotesapp.data.repository

import com.aviirajsharma.quotesapp.data.model.toDomain
import com.aviirajsharma.quotesapp.data.remote.ApiService
import com.aviirajsharma.quotesapp.domain.model.Quote
import com.aviirajsharma.quotesapp.domain.repository.QuoteRepository

//Ye domain layer ke QuoteRepository interface ko implement karta hai.
//Real data yahi fetch karta hai Retrofit se.
//Mapping bhi yahi karta hai.

class QuoteRepositoryImpl (private val apiService: ApiService): QuoteRepository {
    override suspend fun getQuote(): Quote {
        return apiService.getQuote()[0].toDomain()
    }

}