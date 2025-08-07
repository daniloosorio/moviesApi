package com.example.moviesapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

const val  NEW_VERSION = 1
const val OLD_VERSION = 0

@Database(
    version = NEW_VERSION,
    entities = [
        FavoritesEntity::class
    ]
)
abstract class Database: RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}