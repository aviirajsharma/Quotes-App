package com.aviirajsharma.quotesapp.data.model

import com.aviirajsharma.quotesapp.domain.model.Quote

//Mapper banate hain taaki QuoteResponseItem ko Quote me convert kar sakein.
//Data model ko clean model (domain) me change karne ka kaam karta hai.

fun QuoteResponseItem.toDomain(): Quote{
    return Quote(
        quote = this.q,
        author = this.a
    )
}