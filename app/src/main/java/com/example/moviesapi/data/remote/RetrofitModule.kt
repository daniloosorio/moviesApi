package com.example.moviesapi.data.remote

import com.example.moviesapi.repository.MoviesRepository
import com.example.moviesapi.repository.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.time.Duration
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder().connectTimeout(Duration.ofSeconds(1))
            .build()
    }


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(Json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesApiServiceMovies(retrofit: Retrofit): MoviesApiService =
        retrofit.create(MoviesApiService::class.java)

    @Provides
    @Singleton
    fun providesMoviesRepository(
        apiService: MoviesApiService
    ): MoviesRepository = MoviesRepositoryImpl(
        apiService
    )
}