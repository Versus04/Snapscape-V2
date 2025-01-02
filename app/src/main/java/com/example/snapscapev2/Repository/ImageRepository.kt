package com.example.snapscapev2.Repository

import android.media.Image
import com.example.snapscapev2.api.unsplashservice
import com.example.snapscapev2.dto.UnsplashImageDTO
import retrofit2.Response

interface ImageRepository{
    suspend fun getImages() : Response<List<UnsplashImageDTO>>
}
class NetworkImageRepository() : ImageRepository
{
    override suspend fun getImages(): Response<List<UnsplashImageDTO>> {
        return unsplashservice.imageservice.getPhotos()
    }

}