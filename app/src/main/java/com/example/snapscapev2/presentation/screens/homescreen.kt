package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import coil3.compose.AsyncImage
import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel
import com.example.snapscapev2.utils.ImageCard
import com.example.snapscapev2.utils.Screens

@Composable
fun homescreen(scrollViewModel: ScrollViewModel,modifier: Modifier , navController: NavController)
{
    val imagedto = scrollViewModel.imageDto.collectAsState()

   LazyColumn(
       Modifier
           .fillMaxSize()
           .statusBarsPadding()) {
       items(imagedto.value)
       { image ->
           ImageCard(image,
               {
                   navController
                       .navigate(Screens.ProfilePage(
                           username = image.user.username,
                           url = image.user.profile_image.large,
                           totalphotos = image.user.total_photos,
                           collections = image.user.total_collections,
                           totallikes = image.user.total_likes,
                           name = (image.user.first_name) + " " + (image.user.last_name) ?: " ",
                           bio = image.user.bio
                       )) })
       }
   }
}
