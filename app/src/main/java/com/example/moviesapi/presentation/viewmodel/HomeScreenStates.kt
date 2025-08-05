package com.example.moviesapi.presentation.viewmodel

import com.example.moviesapi.domain.MoviesDomainModel

data class HomeScreenStates (
    val listMovies: List<MoviesDomainModel> = emptyList()
)