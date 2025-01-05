package com.example.snapscapev2.paging

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.snapscapev2.api.UnsplashApi
import com.example.snapscapev2.dto.UnsplashImageDTO
import retrofit2.HttpException
import java.io.IOException

class UnsplashPagingSource(val api: UnsplashApi) : PagingSource<Int , UnsplashImageDTO>()
{
    override fun getRefreshKey(state: PagingState<Int, UnsplashImageDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImageDTO> {

        try {
            val page = params.key ?: 1
            val response = api.getPhotos(page = page)

            if (!response.isSuccessful) {

            }

            val photos = response.body() ?: emptyList()

            return LoadResult.Page(
                data = photos,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (photos.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}