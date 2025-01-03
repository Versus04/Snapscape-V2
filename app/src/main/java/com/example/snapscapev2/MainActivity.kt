package com.example.snapscapev2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.snapscapev2.presentation.screens.MainScreen
import com.example.snapscapev2.presentation.screens.homescreen
import com.example.snapscapev2.presentation.viewmodels.ProfileViewModel
import com.example.snapscapev2.presentation.viewmodels.ScrollViewModel
import com.example.snapscapev2.ui.theme.SnapScapeV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val scrollViewModel : ScrollViewModel by viewModels()
        val profileViewModel : ProfileViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnapScapeV2Theme {
                MainScreen(scrollViewModel , profileViewModel)
            }
        }
    }
}
