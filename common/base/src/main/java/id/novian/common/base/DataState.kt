package id.novian.common.base

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    class Failure(val message: String) : DataState<Nothing>()
    class Success<T>(val data: T? = null, val message: String? = null) : DataState<T>()
}
