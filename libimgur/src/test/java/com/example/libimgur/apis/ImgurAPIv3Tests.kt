package com.example.libimgur.apis

import com.example.libimgur.ImgurClient
import com.example.libimgur.params.section
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Tests {

   val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking {
        val response = api.getTags()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - hot working`() = runBlocking{
        val response = api.getGallery(section.HOT)
        assertNotNull(response)
    }

    @Test
    fun `get galleries - top working`() = runBlocking{
        val response = api.getGallery(section.TOP)
        assertNotNull(response)
    }
}