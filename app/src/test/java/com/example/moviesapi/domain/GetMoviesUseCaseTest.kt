package com.example.moviesapi.domain

import com.example.moviesapi.data.Status
import com.example.moviesapi.mockMovies
import com.example.moviesapi.repository.MoviesRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetMoviesUseCaseTest {
    private lateinit var mockRepository: MoviesRepository
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun setup() {
        mockRepository = mockk()
        getMoviesUseCase = GetMoviesUseCase(mockRepository)
    }


    @Test
    fun `invoke get movies and return done`() = runTest {
        //GIVEN
        val movies = mockMovies
        val moviesExpected = mockMovies
        coEvery { mockRepository.getMoviesByPageAndName() } returns Status.Done(movies)

        //WHEN
        val moviesResponse = getMoviesUseCase.invoke()

        //THEN
        assertTrue(moviesResponse is Status.Done)

        val listMovies = moviesResponse as Status.Done
        assertEquals(moviesExpected,listMovies.data )

    }

    @Test
    fun `invoke get movies and return error`() = runTest{
        //GIVE
        coEvery { mockRepository.getMoviesByPageAndName() } returns Status.Error("Error de conexion")

        //WHEN
        val moviesResponse = getMoviesUseCase.invoke()

        //Then
        assertTrue(moviesResponse is Status.Error)
        val error = moviesResponse as Status.Error
        assertEquals(error.messageError, "Error de conexion")
    }
}