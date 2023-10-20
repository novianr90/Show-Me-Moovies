package id.novian.common.network.service

import id.novian.common.base.Constants
import id.novian.common.network.dto.MovieResponse
import id.novian.common.network.dto.single.SingleMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(Constants.Urls.URL_LIST_POPULAR_MOVIES)
    suspend fun getMoviePopular(): MovieResponse

    @GET(Constants.Urls.URL_LIST_DISCOVER_MOVIES)
    suspend fun getDiscoverMovies(): MovieResponse

    @GET(Constants.Urls.URL_DETAILS + "/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") id: Int
    ): SingleMovieResponse

    @GET(Constants.Urls.URL_SEARCH_MOVIES)
    suspend fun searchMoviesByQuery(
        @Query("query") query: String
    ): MovieResponse
}