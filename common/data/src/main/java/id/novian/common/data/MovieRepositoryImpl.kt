package id.novian.common.data

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.map
import id.novian.common.data.local.MovieDao
import id.novian.common.data.mapper.toDomain
import id.novian.common.data.mapper.toEntity
import id.novian.common.domain.MovieRepository
import id.novian.common.domain.model.Movie
import id.novian.common.domain.model.MovieDetails
import id.novian.common.network.paging.MoviePopularPagingDataSource
import id.novian.common.network.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val local: MovieDao,
    private val remote: MovieService,
    private val paging: MoviePopularPagingDataSource
) : MovieRepository {

    override suspend fun getMoviePopular(): Flow<PagingData<Movie>> {
        Log.i("debug", "movie repo pop is invoked")
        return paging.getMoviePopularPagingDataSource()
            .map { pagingData ->
                pagingData.map {
                    Log.i("debug", "content of pop is $it")
                    it.toDomain()
                }
            }
    }

    override suspend fun getDiscoverMovie(): Flow<List<Movie>> {
        Log.i("debug", "movie repo discover invoked")
        return flow {
            val response = remote.getDiscoverMovies()
                .results
                .map { it.toDomain() }
            Log.i("debug", "size of discover is ${response.size}")
            Log.i("debug", "content of discover is ${response[0]}")
            emit(response)
        }
    }

    override suspend fun getMovieDetails(id: Int): Flow<MovieDetails> {
        return flow {
            val response = remote.getDetails(id).toDomain()
            emit(response)
        }
    }

    override suspend fun searchMovieByQuery(query: String): Flow<List<Movie>> {
        return flow {
            val response = remote.searchMoviesByQuery(query)
                .results
                .map { it.toDomain() }

            emit(response)
        }
    }

    override suspend fun addFavorites(movieDetails: MovieDetails): Flow<String> {
        return flow {
            try {
                local.insertId(movieDetails.toEntity())
                emit("Data successfully inserted!")
            } catch (e: Exception) {
                emit(e.message ?: "Error Occurred!")
            }
        }
    }

    override suspend fun getFavorites(): Flow<List<Movie>> {
        return flow {
            val response = local.getListOfFavMovie()
                .map { it.toDomain() }

            emit(response)
        }
    }

    override suspend fun deleteFavorites(id: Int): Flow<String> {
        return flow {
            try {
                local.deleteFavMovieId(id)
                emit("Data successfully deleted!")
            } catch (e: Exception) {
                emit(e.message ?: "Error Occurred!")
            }
        }
    }

    override suspend fun checkFavorites(id: Int): Flow<Boolean> {
        return flow {
            val movie = local.getMovieById(id)

            emit(movie.isNotEmpty())
        }
    }


}