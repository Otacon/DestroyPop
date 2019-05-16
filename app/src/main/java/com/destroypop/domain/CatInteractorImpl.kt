package com.destroypop.domain

import com.destroypop.data.CatRepository
import com.destroypop.domain.model.Cat
import com.destroypop.domain.model.mapper.CatMapper

class CatInteractorImpl(
    val repository: CatRepository,
    val mapper: CatMapper
) : CatInteractor {

    override suspend fun getRandomCat(): Cat =
            mapper.map(repository.getRandomCat())

}