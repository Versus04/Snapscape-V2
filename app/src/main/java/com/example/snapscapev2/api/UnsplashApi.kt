package com.example.snapscapev2.api

import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.utils.CONSTANTS
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://api.unsplash.com/"
interface UnsplashApi {
    @Headers("Authorization: Client-ID ${CONSTANTS.apiKey}")
    @GET("photos")
    suspend fun getPhotos() : Response<List<UnsplashImageDTO>>
}
private val retrofit : Retrofit = Retrofit
    .Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object unsplashservice{
    val imageservice : UnsplashApi by lazy {
        retrofit.create(UnsplashApi::class.java)
    }
}