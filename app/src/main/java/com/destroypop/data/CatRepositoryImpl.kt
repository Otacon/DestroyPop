package com.destroypop.data

class CatRepositoryImpl(val catApi: CatApi) : CatRepository {

    override suspend fun getRandomCat(): CatDto =
        catApi.getRandomCat().await().first()

}