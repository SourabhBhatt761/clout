package com.srb.libimgur

import com.srb.libimgur.apis.ImgurAPIv3
import com.srb.libimgur.params.Section
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurApiV3Tests {

    private val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking {

        val response = api.getTags()
    }

    @Test
    fun `get tags - awww working`() = runBlocking {

        val response = api.getTagGallery("aww")
        print(response.body())
    }

    @Test
     fun `get galleries -hot working`() = runBlocking{
        val response = api.getGallery(Section.HOT)
    }

    @Test
    fun `get galleries -top working`()= runBlocking{
        val response = api.getGallery(Section.TOP)

    }

}