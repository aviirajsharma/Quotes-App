package com.aviirajsharma.quotesapp.data.model


//Ye API se aane wale response ko represent karta hai.
//Raw data hota hai jo map hoke domain model banega.


data class QuoteResponseItem(
    val a: String, //author
    val h: String, //html formatted
    val q: String  // quote
)