package com.aviirajsharma.quotesapp.domain.model

//Ye clean model hai jo UI & app mein use hota hai.
//API se aane wale raw data ko clean bana ke represent karta hai.

data class Quote(
    val quote: String,
    val author: String
)
