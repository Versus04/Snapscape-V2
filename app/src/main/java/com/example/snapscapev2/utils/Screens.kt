package com.example.snapscapev2.utils

import com.example.snapscapev2.dto.User
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {

    @Serializable
    data object Home : Screens()
    @Serializable
    data object Random : Screens()
    @Serializable
    data class ProfilePage(val username : String,
        val url : String,
        val totalphotos : Int ,
        val collections : Int ,
        val totallikes: Int,
        val name : String ,
        val bio : String
        ) : Screens()
    @Serializable
    data object DetailsPage : Screens()
}