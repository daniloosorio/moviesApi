package com.example.moviesapi.repository

import com.example.moviesapi.data.MoviesDataModel
import com.example.moviesapi.data.Status
import com.example.moviesapi.domain.MoviesDomainModel

interface MoviesRepository {

    suspend fun getMoviesByPageAndName():Status<List<MoviesDomainModel>>
}