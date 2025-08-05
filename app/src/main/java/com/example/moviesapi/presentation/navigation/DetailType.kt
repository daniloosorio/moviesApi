package com.example.moviesapi.presentation.navigation

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.moviesapi.domain.MoviesDomainModel
import kotlinx.serialization.json.Json
/*
val detailType =  object : NavType<MoviesDomainModel>(isNullableAllowed = false){
    override fun put(
        bundle: SavedState,
        key: String,
        value: MoviesDomainModel
    ) {
        bundle.putParcelable(key,value)
    }

    override fun get(
        bundle: SavedState,
        key: String
    ): MoviesDomainModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, MoviesDomainModel::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): MoviesDomainModel {
        return Json.decodeFromString<MoviesDomainModel>(value)
    }

    override fun serializeAsValue(value: MoviesDomainModel): String {
        return Uri.encode(Json.encodeToString(value))
    }
}*/