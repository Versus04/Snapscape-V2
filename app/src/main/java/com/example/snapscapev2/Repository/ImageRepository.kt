package com.example.snapscapev2.Repository

import android.media.Image
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.snapscapev2.api.UnsplashApi
import com.example.snapscapev2.api.unsplashservice
import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.paging.UnsplashPagingSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImageRepository{
    suspend fun getImages() : Response<List<UnsplashImageDTO>>

}
class NetworkImageRepository(val api: UnsplashApi) : ImageRepository
{
    override suspend fun getImages(): Response<List<UnsplashImageDTO>> {
        return unsplashservice.imageservice.getPhotos()
    }
    fun getphotosStream(): Flow<PagingData<UnsplashImageDTO>>
    {
        return Pager(
            config = PagingConfig(pageSize = 10 ,
                initialLoadSize = 10,
                enablePlaceholders = false ),
            pagingSourceFactory = { UnsplashPagingSource(api) }
        ).flow
    }

}