package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.snapscapev2.presentation.viewmodels.ProfileViewModel
import com.example.snapscapev2.utils.Screens

@Composable
fun ProfileScreen(details : Screens.ProfilePage , profileViewModel: ProfileViewModel)
{
    val posts = profileViewModel.userImages.collectAsState()
    profileViewModel.updateusername(details.username)
    profileViewModel.getuserPhotos()
    LazyColumn(
        Modifier
            .fillMaxSize()
            .systemBarsPadding())
    {
        item{
            Card(
                Modifier
                    .width(200.dp)
                    .height(200.dp)) {
                Row(){AsyncImage(model = details.url , contentDescription = null, modifier = Modifier.clip(
                    RoundedCornerShape(8.dp)
                ))
                    Text(details.username) }
            }
        }
      items(posts.value)
      { post ->
          AsyncImage(model =  post.urls.small , contentDescription = null)

      }
    }
}

@Composable
fun ProfileCard()
{

}