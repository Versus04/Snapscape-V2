package com.example.snapscapev2.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel

@Composable
fun homescreen(scrollViewModel: ScrollViewModel)
{
    val imagedto = scrollViewModel.imageDto.collectAsState()


}