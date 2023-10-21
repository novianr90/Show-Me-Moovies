package id.novian.common.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.novian.common.data.MoviePopularPagingDataSourceImpl
import id.novian.common.data.MovieRepositoryImpl
import id.novian.common.data.local.LocalDatabase
import id.novian.common.data.local.MovieDao
import id.novian.common.domain.MovieRepository
import id.novian.common.network.paging.MoviePopularPagingDataSource
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
    fun provideMovieDao(localDatabase: LocalDatabase): MovieDao {
        return localDatabase.dao
    }

    @Provides
    fun provideMovieRepository(
        dao: MovieDao,
        movieService: MovieService,
        pagingDataSource: MoviePopularPagingDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(dao, movieService, pagingDataSource)
    }

    @Provides
    fun provideMoviePopularPagingDataSource(movieService: MovieService): MoviePopularPagingDataSource {
        return MoviePopularPagingDataSourceImpl(movieService)
    }
}