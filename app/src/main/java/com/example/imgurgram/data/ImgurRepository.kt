package com.example.imgurgram.data

import com.example.libimgur.ImgurClient
import com.example.libimgur.models.Image
import com.example.libimgur.params.Section

class ImgurRepository {

    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>? {
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }
}