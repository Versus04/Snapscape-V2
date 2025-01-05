package com.example.snapscapev2.api

import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.utils.CONSTANTS
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.unsplash.com/"
interface UnsplashApi {
    @Headers("Authorization: Client-ID ${CONSTANTS.apiKey}")
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page : Int =1
    ) : Response<List<UnsplashImageDTO>>

    @Headers("Authorization: Client-ID ${CONSTANTS.apiKey}")
    @GET("users/{username}/photos")
    suspend fun getuserPhotos(
        @Path("username") username : String
    ): Response<List<UnsplashImageDTO>>
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