package com.example.moviesapi.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MoviesDomainModel (
    val Title : String,
    val Year : String,
    val imdbID: String,
    val Type: String,
    val Poster: String
): Parcelable