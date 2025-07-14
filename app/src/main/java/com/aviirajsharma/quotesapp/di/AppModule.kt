package com.aviirajsharma.quotesapp.di

import com.aviirajsharma.quotesapp.data.remote.ApiService
import com.aviirajsharma.quotesapp.data.repository.QuoteRepositoryImpl
import com.aviirajsharma.quotesapp.domain.repository.QuoteRepository
import com.aviirajsharma.quotesapp.domain.usecase.GetQuoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//Hilt ko batata hai kya inject karna hai.
//ViewModel, UseCase, Repository sab automatically inject ho sakte hain.
//Single source of dependency creation.

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // https://zenquotes.io/api/random
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api/") //base url
            .addConverterFactory(GsonConverterFactory.create()) // Gson Convertor
            .build()
    }


    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideQuoteRepository(apiService: ApiService): QuoteRepository{
        return QuoteRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetQuoteUseCase(repository: QuoteRepository): GetQuoteUseCase{
        return GetQuoteUseCase(repository)
    }
}