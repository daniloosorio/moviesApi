package com.example.moviesapi.repository

import com.example.moviesapi.data.remote.Status
import com.example.moviesapi.domain.MoviesDomainModel

interface MoviesRepository {

    suspend fun getMoviesByPageAndName():Status<List<MoviesDomainModel>>
}