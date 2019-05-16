package com.destroypop.presentation

import com.destroypop.data.CatApi
import com.destroypop.data.CatRepository
import com.destroypop.data.CatRepositoryImpl
import com.destroypop.domain.CatInteractor
import com.destroypop.domain.CatInteractorImpl
import com.destroypop.domain.model.mapper.CatMapper
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainServiceLocator : ServiceLocator {

    fun getInteractor(): CatInteractor =
        CatInteractorImpl(createRepository(), createMapper())

    private fun createMapper(): CatMapper =
        CatMapper()

    private fun createRepository(): CatRepository =
        CatRepositoryImpl(createApi())

    private fun createApi(): CatApi =
        createRetrofit()
            .create(CatApi::class.java)

    private fun createRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/images/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
}