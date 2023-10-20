package id.novian.common.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val backdropPath: String,
    val overview: String,
    val releaseDate: String
)
