package id.novian.common.domain

import androidx.paging.PagingData
import id.novian.common.domain.model.Movie
import id.novian.common.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMoviePopular(): Flow<PagingData<Movie>>

    suspend fun getDiscoverMovie(): Flow<List<Movie>>

    suspend fun getMovieDetails(id: Int): Flow<MovieDetails>

    suspend fun searchMovieByQuery(query: String): Flow<List<Movie>>

    suspend fun addFavorites(movieDetails: MovieDetails): Flow<String>

    suspend fun getFavorites(): Flow<List<Movie>>

    suspend fun deleteFavorites(id: Int): Flow<String>

    suspend fun checkFavorites(id: Int): Flow<Boolean>
}