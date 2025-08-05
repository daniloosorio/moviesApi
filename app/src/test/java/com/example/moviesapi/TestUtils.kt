package com.example.moviesapi

import com.example.moviesapi.domain.MoviesDomainModel

val mockMovies = listOf(
    MoviesDomainModel(
        Title = "Batman: The Killing Joke",
        Year = "2016",
        imdbID = "tt4853102",
        Type = "movie",
        Poster = "https://m.media-amazon.com/images/M/MV5BMzJiZTJmNGItYTUwNy00ZWE2LWJlMTgtZjJkNzY1OTRiNTZlXkEyXkFqcGc@._V1_SX300.jpg"
    ), MoviesDomainModel(
        Title = "Batman: Mask of the Phantasm",
        Year = "1993",
        imdbID = "tt0106364",
        Type = "movie",
        Poster = "https://m.media-amazon.com/images/M/MV5BYjYwN2ZmZWYtMTdlNC00ZDQxLWEyNmUtZDI5Yjk5MzQ2N2Y3XkEyXkFqcGc@._V1_SX300.jpg"
    )
)
