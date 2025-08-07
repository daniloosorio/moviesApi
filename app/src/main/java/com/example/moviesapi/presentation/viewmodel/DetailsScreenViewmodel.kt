package com.example.moviesapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapi.domain.FavoritesDomainModel
import com.example.moviesapi.domain.GetAllFavoritesUseCase
import com.example.moviesapi.domain.InsertFavoriteUseCase
import com.example.moviesapi.domain.MoviesDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewmodel @Inject constructor(
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
): ViewModel() {

    fun insertFavorite(item:MoviesDomainModel){
        viewModelScope.launch(Dispatchers.IO) {
            insertFavoriteUseCase(
                FavoritesDomainModel(
                    Title = item.Title,
                    Year = item.Year,
                    imdbID = item.imdbID,
                    Type=item.Type,
                    Poster=item.Poster
                )
            )
        }
    }

    fun getAllFavorites(){
        viewModelScope.launch {
            getAllFavoritesUseCase.getAllFavorites()
        }
    }
}