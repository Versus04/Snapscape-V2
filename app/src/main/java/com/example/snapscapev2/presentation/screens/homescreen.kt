package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import coil3.compose.AsyncImage
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel

@Composable
fun homescreen(scrollViewModel: ScrollViewModel)
{
    val imagedto = scrollViewModel.imageDto.collectAsState()

   LazyColumn {
       items(imagedto.value)
       { image ->
           AsyncImage(model = image.links.download , contentDescription = null)

       }
   }
}