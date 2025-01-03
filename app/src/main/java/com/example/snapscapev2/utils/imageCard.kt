package com.example.snapscapev2.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.snapscapev2.dto.UnsplashImageDTO

@Composable
fun ImageCard(unsplashImageDTO: UnsplashImageDTO , onclick: ()-> Unit)
{
    Card(colors = CardDefaults.cardColors(),
        modifier = Modifier.width(unsplashImageDTO.width.dp).clickable(onClick = onclick)
        .padding(8.dp)
    )
    {
        Column {
            Row (
                verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.Center
                , modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ){
                AsyncImage(model = unsplashImageDTO.user.profile_image.large
                    , contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = unsplashImageDTO.user.name,
                    style = MaterialTheme.typography.titleMedium
                    )
            }
            AsyncImage(
                model = unsplashImageDTO.urls.raw,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

    }
}