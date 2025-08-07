package com.example.moviesapi.domain

import com.example.moviesapi.repository.DatabaseRepository
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend fun getAllFavorites(){
        databaseRepository.getAllFavorites()
    }
}