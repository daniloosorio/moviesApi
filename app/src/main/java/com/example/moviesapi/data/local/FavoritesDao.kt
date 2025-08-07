package com.example.moviesapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritesDao {

    @Insert(entity = FavoritesEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewFavorite(newFavorite: FavoritesEntity):Long


    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites():List<FavoritesEntity>
}