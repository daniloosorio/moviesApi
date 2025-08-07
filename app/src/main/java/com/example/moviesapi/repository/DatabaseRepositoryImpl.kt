package com.example.moviesapi.repository

import com.example.moviesapi.data.local.FavoritesDao
import com.example.moviesapi.data.local.FavoritesEntity
import com.example.moviesapi.domain.FavoritesDomainModel
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val favoritesDao: FavoritesDao) : DatabaseRepository {
    override suspend fun insertNewFavorite(favorites: FavoritesDomainModel): Long {
        return favoritesDao.insertNewFavorite(favorites.toEntity())
    }

    override suspend fun getAllFavorites(): List<FavoritesDomainModel> {
        return favoritesDao.getAllFavorites().map { it.toDomain() }
    }
}


