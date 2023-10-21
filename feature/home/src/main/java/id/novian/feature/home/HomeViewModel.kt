package id.novian.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import id.novian.common.base.DataState
import id.novian.common.domain.MovieRepository
import id.novian.common.domain.model.Movie
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    init {

        fetchPopular()
        fetchDiscover()
    }

    fun test() {
        Log.i("home", "invoked")
        print("HI MOM")
    }

    private val _discoverState: MutableStateFlow<DataState<List<Movie>>> =
        MutableStateFlow(DataState.Empty)
    val discoverState: StateFlow<DataState<List<Movie>>> = _discoverState

    private val _popularState: MutableStateFlow<DataState<PagingData<Movie>>> =
        MutableStateFlow(DataState.Empty)
    val popularState: StateFlow<DataState<PagingData<Movie>>> = _popularState

    private fun fetchDiscover() {
        viewModelScope.launch {
            _discoverState.value = DataState.Loading
            try {
                movieRepository.getDiscoverMovie()
                    .collect { list ->
                        if (list.isEmpty()) {
                            _discoverState.value = DataState.Empty
                        }

                        _discoverState.value = DataState.Success(list)
                        Log.i("disc", "size of discover is ${list.size}")
                        Log.i("disc", "content of discover is ${list[0]}")
                    }
            } catch (e: Exception) {
                // Log the error
                Log.e("HomeViewModel", "Error fetching discover movies", e)

                // Display an error message to the user
                _discoverState.value = DataState.Failure(e.message ?: "Error Occurred!")
            }
        }
    }

    private fun fetchPopular() {
        Log.i("disc", "method in viewmodel invoked pop")
        viewModelScope.launch {
            _popularState.value = DataState.Loading
            movieRepository.getMoviePopular()
                .onCompletion {
                    if (it is CancellationException) {
                        Log.e("HomeViewModel", "Fetch discover movies cancelled")
                    } else if (it is Exception) {
                        Log.e("HomeViewModel", "Error fetching discover movies", it)
                    }
                }
                .collectLatest {
                    Log.i("popop", "content of pop is ${it.map { data -> data }}")
                    _popularState.value = DataState.Success(it)
                }
        }
    }

    suspend fun getPopular(): Flow<PagingData<Movie>> {
        Log.i("pop", "invoked")
        return movieRepository.getMoviePopular()
            .catch { DataState.Failure(it.message ?: "") }
            .cachedIn(viewModelScope)
    }
}