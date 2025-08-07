package com.example.moviesapi.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapi.data.remote.Status
import com.example.moviesapi.domain.GetMoviesUseCase
import com.example.moviesapi.domain.InsertFavoriteUseCase
import com.example.moviesapi.domain.MoviesDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class HomeScreenViewmodel
    @Inject constructor(
        private val getMoviesUseCase : GetMoviesUseCase //Dependecy injection
    ): ViewModel() {
    private val _states = MutableStateFlow(HomeScreenStates()) // encapsulamiento
    val uiState : StateFlow<HomeScreenStates> = _states.asStateFlow()

    init {
        getMovies()
    }

    fun getMovies(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            val statusResponse = getMoviesUseCase()
                when (statusResponse){
                    is Status.Done<List<MoviesDomainModel>> -> {
                        _states.value = _states.value.copy(listMovies = statusResponse.data)
                        Log.d("logData",statusResponse.data.toString())
                    }
                    is Status.Error -> {
                        Log.d("logData",statusResponse.messageError)
                    }
                    is Status.Loading -> {
                        Log.d("logData","cargando...")
                    }
                }
            }
        }
    }
}