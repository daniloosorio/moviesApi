package com.example.moviesapi.data.local

import android.app.Application
import android.content.Context
import androidx.compose.ui.test.TestContext
import androidx.room.Room
import androidx.test.runner.AndroidJUnitRunner
import com.example.moviesapi.repository.DatabaseRepository
import com.example.moviesapi.repository.DatabaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestDatabaseModule {

    @Provides
    @Named("test_db")
    fun providesInMemoryDatabase(@ApplicationContext context: Context): Database {
        return Room.inMemoryDatabaseBuilder(context, Database::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun providesTestFavoritesDao(@Named("test_db") database: Database): FavoritesDao =
        database.favoritesDao()

    @Provides
    fun providesTestDatabaseRepository(favoritesDao: FavoritesDao): DatabaseRepository =
        DatabaseRepositoryImpl(favoritesDao)
}

