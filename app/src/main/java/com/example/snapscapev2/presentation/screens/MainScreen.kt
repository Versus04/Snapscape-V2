package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel
import com.example.snapscapev2.utils.Screens

@Composable
fun MainScreen(scrollViewModel: ScrollViewModel)
{
    val navController  = rememberNavController()
    Scaffold() { innerPadding ->
        NavHost(navController=navController , startDestination = Screens.Home)
        {
            composable<Screens.Home>
            {
                homescreen(scrollViewModel = scrollViewModel , modifier = Modifier.padding(innerPadding))
            }
        }

    }
}