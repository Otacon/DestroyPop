package com.destroypop.domain.model.mapper

interface Mapper<in M, out T> {

    fun map(input: M): T

}