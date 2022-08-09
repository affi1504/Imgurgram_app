package com.example.libimgur.apis

import com.example.libimgur.ImgurClient
import com.example.libimgur.params.Section
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test


class ImgurAPIv3Tests {

   val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking {
        val response = api.getTags()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - hot working`() = runBlocking{
        val response = api.getGallery(Section.HOT)
        assertNotNull(response)
    }

    @Test
    fun `get galleries - top working`() = runBlocking{
        val response = api.getGallery(Section.TOP)
        assertNotNull(response)
    }

    @Test
    fun `get tags - cat working`() = runBlocking {
        val response = api.getTagGallery("cat")
        assertNotNull(response.body())
    }
}