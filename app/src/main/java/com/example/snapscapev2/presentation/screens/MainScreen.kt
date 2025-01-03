package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.snapscapev2.presentation.viewmodels.ProfileViewModel
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel
import com.example.snapscapev2.utils.Screens

@Composable
fun MainScreen(scrollViewModel: ScrollViewModel , profileViewModel: ProfileViewModel)
{
    val navController  = rememberNavController()
    Scaffold() { innerPadding ->
        NavHost(navController=navController , startDestination = Screens.Home)
        {
            composable<Screens.Home>
            {
                homescreen(scrollViewModel = scrollViewModel ,
                    modifier = Modifier.padding(innerPadding),
                    navController)
            }
            composable<Screens.ProfilePage>
            {
                val curr = it.toRoute<Screens.ProfilePage>()
                ProfileScreen(curr , profileViewModel)
            }
        }

    }
}