package com.example.snapscapev2.utils

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {

    @Serializable
    data object Home : Screens()
    @Serializable
    data object random : Screens()
}