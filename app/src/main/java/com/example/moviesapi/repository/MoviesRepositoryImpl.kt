package com.example.moviesapi.repository

import com.example.moviesapi.data.MoviesApiService
import com.example.moviesapi.data.MoviesDataModel
import com.example.moviesapi.data.Status
import com.example.moviesapi.domain.MoviesDomainModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import okio.IOException
import retrofit2.awaitResponse
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiService: MoviesApiService
) : MoviesRepository{
    override suspend fun getMoviesByPageAndName(): Status<List<MoviesDomainModel>> {
       return try {
           val response = apiService.getMoviesByPageAndSearch().awaitResponse()
           if(response.isSuccessful){
               val bodyResponse = response.body()!!.Response
               if( bodyResponse == "True"){
                   Status.Done(response.body()!!.Search.map { it.toDomain()})
               }else{
                   Status.Error("Bad Data")
               }
           }else{
               val error = response.errorBody()?.string()
               Status.Error("code :${response.code()}, error:$error")
           }
       }catch (e: IOException){
           Status.Error(e.localizedMessage ?: "Api Error")
       }catch (e: Exception){
           Status.Error(e.message ?: "Error Conexion")
       }
    }


}

