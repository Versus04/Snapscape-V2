package com.example.snapscapev2.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.snapscapev2.Repository.NetworkImageRepository
import com.example.snapscapev2.api.UnsplashApi
import com.example.snapscapev2.api.unsplashservice
import com.example.snapscapev2.dto.UnsplashImageDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScrollViewModel : ViewModel() {
    private val _imagedto  = MutableStateFlow<List<UnsplashImageDTO>>(emptyList())
    val imageDto : StateFlow<List<UnsplashImageDTO>> = _imagedto.asStateFlow()
    val imageRepository = NetworkImageRepository(api = unsplashservice.imageservice)
    val photos : Flow<PagingData<UnsplashImageDTO>> = imageRepository.getphotosStream()
    fun getphotos()
    {
        viewModelScope.launch()
        {
            try {
                val response = imageRepository.getImages()
                response.body()?.let { images->
                    _imagedto.value = images
                }
            }
            catch (e: Exception)
            {
                Log.d("real" , e.toString())
            }
        Log.d("sdfa" , _imagedto.value.toString())
        }
    }

    init {
        getphotos()

    }
}