package com.example.moviesapi.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.moviesapi.repository.DatabaseRepository
import com.example.moviesapi.repository.DatabaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context,Database::class.java,"database.db")
            //.addMigrations(MIGRATION_0_1)
            .build()
    }

    @Provides
    fun providesFavoritesDao(database: Database): FavoritesDao =
        database.favoritesDao()

    @Provides
    fun providesDatabaseRepository(
        favoritesDao: FavoritesDao
    ): DatabaseRepository = DatabaseRepositoryImpl(
        favoritesDao
    )

    private val MIGRATION_0_1 = object : Migration(0,1){
        override fun migrate(db: SupportSQLiteDatabase) {
            //db.execSQL("DROP TABLE tablename")
        }
    }
}