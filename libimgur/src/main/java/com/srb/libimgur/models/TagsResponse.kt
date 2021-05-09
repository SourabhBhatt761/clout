package com.srb.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagsResponse(
    val `data`: Data,
    val status: Int,
    val success: Boolean
)