package com.example.snapscapev2.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

import coil3.compose.AsyncImage
import com.example.snapscapev2.dto.UnsplashImageDTO
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel
import com.example.snapscapev2.utils.ImageCard
import com.example.snapscapev2.utils.Screens

@Composable
fun homescreen(
    scrollViewModel: ScrollViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        val photos = scrollViewModel.photos.collectAsLazyPagingItems()

        when {
            // Show loading state when photos are null or empty
            photos.itemCount == 0 -> {
                LoadingItem()
            }
            // Show content when we have photos
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(
                        count = photos.itemCount,
                        key = { index -> "${photos[index]?.id}_$index" }
                    ) { index ->
                        photos[index]?.let { photo ->
                            ImageCard(
                                unsplashImageDTO = photo,
                                profile = {
                                    navController.navigate(
                                        Screens.ProfilePage(
                                            username = photo.user.username ?: "",
                                            url = photo.user.profile_image?.large ?: "",
                                            totalphotos = photo.user.total_photos ?: 0,
                                            collections = photo.user.total_collections ?: 0,
                                            totallikes = photo.user.total_likes ?: 0,
                                            name = buildString {
                                                append(photo.user.first_name ?: "")
                                                if (!photo.user.last_name.isNullOrEmpty()) {
                                                    append(" ${photo.user.last_name}")
                                                }
                                            },
                                            bio = photo.user.bio ?: ""
                                        )
                                    )
                                },
                                image = { 
                                    photo.urls.full?.let { url ->
                                        navController.navigate(Screens.imagePage(url = url))
                                    }
                                }
                            )
                        }
                    }

                    photos.apply {
                        when {
                            loadState.refresh is LoadState.Loading -> {
                                item { LoadingItem() }
                            }
                            loadState.refresh is LoadState.Error -> {
                                item {
                                    val error = (loadState.refresh as LoadState.Error).error
                                    Log.e("HomeScreen", "Refresh error", error)
                                    ErrorItem(
                                        message = error.localizedMessage ?: "Error loading images",
                                        onRetryClick = { retry() }
                                    )
                                }
                            }
                            loadState.append is LoadState.Loading -> {
                                item { LoadingItem() }
                            }
                            loadState.append is LoadState.Error -> {
                                item {
                                    val error = (loadState.append as LoadState.Error).error
                                    Log.e("HomeScreen", "Append error", error)
                                    ErrorItem(
                                        message = error.localizedMessage ?: "Error loading more images",
                                        onRetryClick = { retry() }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(
    message: String,
    onRetryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message)
        Button(onClick = onRetryClick) {
            Text(text = "Retry")
        }
    }
}
