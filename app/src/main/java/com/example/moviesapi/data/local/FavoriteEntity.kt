package com.example.moviesapi.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoritesEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo("imdbID") val imdbID: String,
    @ColumnInfo("title") val Title : String,
    @ColumnInfo("year") val Year : String,
    @ColumnInfo("type") val Type: String,
    @ColumnInfo("poster") val Poster: String
)