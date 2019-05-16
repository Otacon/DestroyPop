package com.destroypop.domain

import com.destroypop.domain.model.Cat

interface CatInteractor {

    suspend fun getRandomCat(): Cat

}