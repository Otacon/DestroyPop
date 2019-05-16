package com.destroypop.data

import com.google.gson.annotations.SerializedName

data class CatDto(
    @SerializedName("url")
    val url: String
)