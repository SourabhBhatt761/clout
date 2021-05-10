package com.srb.clout.data

import com.srb.libimgur.models.Gallery
import com.srb.libimgur.models.Image
import com.srb.libimgur.models.Tag
import com.srb.libimgur.params.Section

class CloutRepository {

    private val api = ImgurClient.api

    suspend fun getHotFeed():List<Image>?{
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed():List<Image>?{
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTags() : List<Tag>?{
        val response = api.getTags()
        return response.body()?.data?.tags
    }
}