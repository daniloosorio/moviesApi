package com.example.moviesapi.data

import com.example.moviesapi.domain.MoviesDomainModel
import kotlinx.serialization.Serializable


@Serializable
data class ResponseModel(
    val Response: String,
    val totalResults: String,
    val Search:List<MoviesDataModel>
)

@Serializable
data class MoviesDataModel(
    val Title : String,
    val Year : String,
    val imdbID: String,
    val Type: String,
    val Poster: String
){
    fun toDomain(): MoviesDomainModel =
        MoviesDomainModel(
            Title = Title,
            Year = Year,
            imdbID = imdbID,
            Type = Type,
            Poster = Poster
        )
}