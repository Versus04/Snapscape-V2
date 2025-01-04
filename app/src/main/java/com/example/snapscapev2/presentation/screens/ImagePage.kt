package com.example.snapscapev2.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil3.compose.AsyncImage
import com.example.snapscapev2.utils.Screens

@Composable
fun ImagePage(url : Screens.imagePage)
{
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier.fillMaxSize().background(color = Color.Black).systemBarsPadding()){
        AsyncImage(model = url.url , contentDescription = null)

    }


}