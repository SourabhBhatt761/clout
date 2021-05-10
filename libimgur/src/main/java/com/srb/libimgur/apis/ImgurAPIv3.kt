package com.srb.libimgur.apis

import com.srb.libimgur.models.GalleryResponse
import com.srb.libimgur.models.TagsResponse
import com.srb.libimgur.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {


    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path ("section") section : Section,
        @Query ("album_previews") albumPreviews : Boolean? = true
    ): Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag: String
    ): Response<TagsResponse>


}