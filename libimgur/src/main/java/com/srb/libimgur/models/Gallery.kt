package com.srb.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gallery(
    val description: String,
    val id: Int?,
    val name: String?,
    val topPost: TopPost
)