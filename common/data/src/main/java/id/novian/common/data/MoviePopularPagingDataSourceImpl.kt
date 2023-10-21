package id.novian.common.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import id.novian.common.base.Constants
import id.novian.common.network.dto.Result
import id.novian.common.network.paging.MoviePopularPagingDataSource
import id.novian.common.network.service.MovieService
import kotlinx.coroutines.flow.Flow

class MoviePopularPagingDataSourceImpl(
    private val movieService: MovieService
) : MoviePopularPagingDataSource {
    override fun getMoviePopularPagingDataSource(): Flow<PagingData<Result>> {
        Log.i("debug", "paging data source invoked")
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = {
                MoviesPagingSource(movieService)
            }
        ).flow
    }
}