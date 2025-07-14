package com.aviirajsharma.quotesapp.data.remote

import com.aviirajsharma.quotesapp.data.model.QuoteResponseItem
import retrofit2.http.GET

//Retrofit ka interface hai.
//Yahi API call karta hai.


interface ApiService {

    @GET("random")
    suspend fun getQuote() : List<QuoteResponseItem>
}