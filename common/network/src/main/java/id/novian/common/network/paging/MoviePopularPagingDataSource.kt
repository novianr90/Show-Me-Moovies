package id.novian.common.network.paging

import androidx.paging.PagingData
import id.novian.common.network.dto.Result
import kotlinx.coroutines.flow.Flow

interface MoviePopularPagingDataSource {
    fun getMoviePopularPagingDataSource(): Flow<PagingData<Result>>
}