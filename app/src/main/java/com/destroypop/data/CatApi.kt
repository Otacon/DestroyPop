package com.destroypop.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CatApi {

    @GET("search")
    fun getRandomCat(): Deferred<List<CatDto>>

}