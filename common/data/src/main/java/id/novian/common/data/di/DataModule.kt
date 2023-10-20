package id.novian.common.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.novian.common.data.MovieRepositoryImpl
import id.novian.common.data.local.LocalDatabase
import id.novian.common.domain.MovieRepository
import id.novian.common.network.service.MovieService

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "favorites"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieRepository(
        localDatabase: LocalDatabase,
        movieService: MovieService
    ): MovieRepository {
        return MovieRepositoryImpl(localDatabase.dao, movieService)
    }
}