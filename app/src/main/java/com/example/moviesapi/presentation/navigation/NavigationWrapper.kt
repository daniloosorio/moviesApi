package com.example.moviesapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.moviesapi.domain.MoviesDomainModel
import com.example.moviesapi.presentation.screens.DetailsScreen
import com.example.moviesapi.presentation.screens.HomeScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController= navController,startDestination = Home){
        composable<Home>{
            HomeScreen(navigateToDetail = { item ->
                navController.navigate(Detail(item))
            })
        }

        composable<Detail>(typeMap = mapOf(typeOf<MoviesDomainModel>() to createNavType<MoviesDomainModel>())){ backStackEntry ->
            val item : Detail = backStackEntry.toRoute()
            DetailsScreen(item = item.item)
        }
    }
}