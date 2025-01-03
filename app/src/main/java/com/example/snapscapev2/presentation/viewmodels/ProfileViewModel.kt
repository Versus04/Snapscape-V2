package com.example.snapscapev2.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snapscapev2.api.unsplashservice
import com.example.snapscapev2.dto.UnsplashImageDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel()
{
    private val _userImages = MutableStateFlow<List<UnsplashImageDTO>>(emptyList())
    val userImages : StateFlow<List<UnsplashImageDTO>> = _userImages.asStateFlow()
    private val _username = MutableStateFlow("")
    val username : StateFlow<String> = _username.asStateFlow()
    fun updateusername(username : String)
    {

    }
    fun getuserPhotos()
    {
        viewModelScope.launch()
        {
            val response = unsplashservice.imageservice.getuserPhotos(_username.value)
            response.body()?.let { photos ->
                _userImages.value = photos
            }
        }
    }
}