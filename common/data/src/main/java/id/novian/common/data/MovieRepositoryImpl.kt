package id.novian.common.data

import id.novian.common.data.local.MovieDao
import id.novian.common.data.mapper.toDomain
import id.novian.common.data.mapper.toEntity
import id.novian.common.domain.MovieRepository
import id.novian.common.domain.model.Movie
import id.novian.common.domain.model.MovieDetails
import id.novian.common.network.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val local: MovieDao,
    private val remote: MovieService
) : MovieRepository {
    override suspend fun getMoviePopular(page: Int): Flow<List<Movie>> {
        return flow {
            val response = remote.getMoviePopular(page)
                .results
                .map { it.toDomain() }

            emit(response)
        }
    }

    override suspend fun getDiscoverMovie(): Flow<List<Movie>> {
        return flow {
            val response = remote.getDiscoverMovies()
                .results
                .map { it.toDomain() }

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
}