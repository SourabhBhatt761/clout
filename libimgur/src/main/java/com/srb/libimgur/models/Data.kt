package com.srb.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val featured: String,
    val galleries: List<Gallery>,
    val tags: List<Tag>
)