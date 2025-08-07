package com.example.moviesapi.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface MoviesApiService {

    @GET("?page=2&apikey=e5a01599&s=Batman")
    fun getMoviesByPageAndSearch(): Call<ResponseModel>

}