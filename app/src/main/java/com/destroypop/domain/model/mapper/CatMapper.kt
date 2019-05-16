package com.destroypop.domain.model.mapper

import com.destroypop.data.CatDto
import com.destroypop.domain.model.Cat

class CatMapper : Mapper<CatDto, Cat> {

    override fun map(input: CatDto): Cat =
            Cat(input.url)

}