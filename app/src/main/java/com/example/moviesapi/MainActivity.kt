package com.example.moviesapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moviesapi.presentation.navigation.NavigationWrapper
import com.example.moviesapi.presentation.screens.HomeScreen
import com.example.moviesapi.presentation.theme.MoviesApiTheme
import dagger.hilt.android.AndroidEntryPoint

const val API_KEY = "e5a01599"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesApiTheme {
                NavigationWrapper()
            }
        }
    }
}


