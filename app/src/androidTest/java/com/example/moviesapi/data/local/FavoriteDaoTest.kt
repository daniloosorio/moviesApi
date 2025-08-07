package com.example.moviesapi.data.local

import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
@SmallTest
class FavoriteDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_db")
    lateinit var database: Database
    private lateinit var favoritesDao: FavoritesDao

    @Before
    fun setup(){
        hiltRule.inject()
        favoritesDao = database.favoritesDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertAndGet() = runTest {
        val favoritesEntity = FavoritesEntity("a","b","c","d","e")
        favoritesDao.insertNewFavorite(favoritesEntity)

        val favorite =  favoritesDao.getAllFavorites()
        assert(favorite.isNotEmpty())
        assertEquals("a",favorite[0].imdbID)
    }
}