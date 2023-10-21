package id.novian.common.base

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500"

    const val NETWORK_PAGE_SIZE = 25

    object Urls {
        const val URL_LIST_POPULAR_MOVIES = "movie/popular"
        const val URL_LIST_DISCOVER_MOVIES = "discover/movie"
        const val URL_DETAILS = "movie"
        const val URL_SEARCH_MOVIES = "search/movie"
    }

    object TimeOut {
        const val READ = 30L
        const val CONNECT = 30L
        const val WRITE = 30L
    }

    object Header {
        const val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9." +
                "eyJhdWQiOiI3NDE2M2UzZmQ5N2IzODcxOGFhMDA5OTljYjgxZjcyMyIsInN1YiI6IjYyNTRlMmNmMzczYWMyMDA5ZDBhMGRjOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ." +
                "7LIUQjzm4GyBbO5Z8YPzadpWVdwuVrR-eyuuuK9-X7A"
        const val AUTH_HEADER = "Authorization"
        const val AUTH_HEADER_PREFIX = "Bearer"
        const val ACCEPT_HEADER = "accept"
        const val JSON_ACCEPT = "application/json"
    }
}