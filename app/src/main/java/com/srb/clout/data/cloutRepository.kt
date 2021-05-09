package com.srb.clout.data

import com.srb.libimgur.models.Image
import com.srb.libimgur.params.Section

class cloutRepository {

    val api = ImgurClient.api

    suspend fun getHotFeed():List<Image>?{
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed():List<Image>?{
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }
}