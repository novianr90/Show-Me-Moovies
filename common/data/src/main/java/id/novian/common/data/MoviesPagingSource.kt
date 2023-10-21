package id.novian.common.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.novian.common.base.Constants
import id.novian.common.network.dto.Result
import id.novian.common.network.service.MovieService
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE = 1

class MoviesPagingSource(
    private val service: MovieService
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPos ->
            state.closestPageToPosition(anchorPos)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPos)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageIndex = params.key ?: STARTING_PAGE
        return try {
            val response = service.getMoviePopular(
                page = pageIndex
            )
            val movies = response.results
            Log.i("debug", "movie paging size of pop is ${movies.size}")
            Log.i("debug", "movie paging content of pop is ${movies[0]}")
            val nextKey =
                if (movies.isEmpty()) {
                    null
                } else {
                    pageIndex + (params.loadSize / Constants.NETWORK_PAGE_SIZE)
                }
            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == STARTING_PAGE) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}