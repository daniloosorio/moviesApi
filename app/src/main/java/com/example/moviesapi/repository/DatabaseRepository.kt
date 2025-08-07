package com.example.moviesapi.repository

import androidx.room.Insert
import com.example.moviesapi.domain.FavoritesDomainModel

//Dependecy inversion
interface DatabaseRepository {
    suspend fun insertNewFavorite(favorites: FavoritesDomainModel):Long

    suspend fun getAllFavorites():List<FavoritesDomainModel>
}