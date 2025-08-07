package com.example.moviesapi.domain

import com.example.moviesapi.data.remote.Status
import com.example.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(): Status<List<MoviesDomainModel>> {
        return moviesRepository.getMoviesByPageAndName()
    }
}