package com.example.moviesapi.domain

import com.example.moviesapi.repository.DatabaseRepository
import javax.inject.Inject


class InsertFavoriteUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend operator fun invoke(favorite: FavoritesDomainModel):Long{
        //to do other things if is necesary
        return databaseRepository.insertNewFavorite(favorite)
    }
}