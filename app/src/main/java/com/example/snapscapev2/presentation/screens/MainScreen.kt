package com.example.snapscapev2.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen()
{
    val navController  = rememberNavController()
    Scaffold() { innerPadding ->

        Text("", modifier = Modifier.padding(innerPadding))
    }
}