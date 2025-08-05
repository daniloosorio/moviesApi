package com.example.moviesapi.presentation.navigation

import com.example.moviesapi.domain.MoviesDomainModel
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail (val item: MoviesDomainModel)