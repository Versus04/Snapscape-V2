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
    data object ProfilePage : Screens()
    @Serializable
    data object DetailsPage : Screens()
}