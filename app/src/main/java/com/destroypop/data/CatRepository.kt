package com.destroypop.data

import com.destroypop.domain.model.Cat

interface CatRepository {

    suspend fun getRandomCat(): CatDto

}