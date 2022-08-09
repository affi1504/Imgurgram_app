package com.example.libimgur

import com.example.libimgur.apis.ImgurAPIv3
import com.example.libimgur.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.http.HttpClient

object ImgurClient {
const val API_KEY = "b91bd7d5f545cc9"
    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor{
            val request = it.request()
                .newBuilder()
                .addHeader("Authorization","Client-ID $API_KEY")
                .build()
            it.proceed(request)
        }
            .build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/")
            .build()
    }

     val api : ImgurAPIv3 by lazy {
         retrofit.create(ImgurAPIv3::class.java)
     }
}