package com.example.moviesapi.repository

import com.example.moviesapi.data.local.FavoritesEntity
import com.example.moviesapi.domain.FavoritesDomainModel

//Adapter pattern
fun FavoritesDomainModel.toEntity(): FavoritesEntity {
    return FavoritesEntity(
        imdbID = this.imdbID,
        Title = this.Title,
        Year = this.Year,
        Type = this.Type,
        Poster = this.Poster
    )
}
fun FavoritesEntity.toDomain(): FavoritesDomainModel {
    return FavoritesDomainModel(
        Title = this.imdbID,
        Year = this.Title,
        imdbID = this.Year,
        Type = this.Type,
        Poster = this.Poster
    )
}