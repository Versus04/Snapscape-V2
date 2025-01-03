package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import coil3.compose.AsyncImage
import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.presentation.viewmodels.ProfileViewModel
import com.example.snapscapev2.utils.Screens

@Composable
fun ProfileScreen(details : Screens.ProfilePage , profileViewModel: ProfileViewModel)
{
    val posts = profileViewModel.userImages.collectAsState()
    profileViewModel.updateusername(details.username)
    profileViewModel.getuserPhotos()
    Column(
        Modifier
            .fillMaxSize()
            .systemBarsPadding())
    {

            Column(modifier = Modifier.fillMaxWidth().padding(16.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.SpaceEvenly , modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(model = details.url,
                        contentDescription = null,
                        modifier = Modifier.height(100.dp).width(100.dp).clip(RoundedCornerShape(64.dp))

                    )
                    content(details.totalphotos,"Photos")
                    content(details.totallikes , "Likes")
                    content(details.collections,"Collections")
                }
                Text(details.name)
                Text(details.bio)

            }



        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize())
        {
      items(posts.value)
      { post ->
            images(post)

      }
    }
}}
@Composable
fun images(post: UnsplashImageDTO)
{
    AsyncImage(model = post.urls.regular ,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.padding(start = 8.dp,end=8.dp , bottom = 8.dp).width(post.width.dp).clip(RoundedCornerShape(8.dp))
    )
}
@Composable
fun ProfileCard(username : String  , url: String)
{


}
@Composable
fun content(number : Int ,contentType: String )
{
    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) { Text(number.toString())
        Text(contentType)
    }
}