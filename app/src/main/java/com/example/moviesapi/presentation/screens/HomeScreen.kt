package com.example.moviesapi.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.moviesapi.domain.MoviesDomainModel
import com.example.moviesapi.presentation.viewmodel.HomeScreenViewmodel

@Composable
fun HomeScreen(
    navigateToDetail: (MoviesDomainModel) -> Unit,
    viewmodel: HomeScreenViewmodel = hiltViewModel()
){
    val uiState = viewmodel.uiState.collectAsState().value
    Scaffold { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.background(color = Color.DarkGray).fillMaxSize().padding(innerPadding).padding(horizontal = 16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.listMovies, key = { it.imdbID }) { item ->
                Card(Modifier.clickable {
                    navigateToDetail(item)
                }) {
                    Column {
                        Box(Modifier.height(200.dp).background(color = Color.Red)) {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                model = item.Poster,
                                contentDescription = "movie poster",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Text(item.Title, maxLines = 1)
                    }
                }
            }
        }
    }
}
