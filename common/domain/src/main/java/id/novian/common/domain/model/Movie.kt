package id.novian.common.domain.model

import androidx.annotation.Keep

@Keep
data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val backdropPath: String,
    val overview: String,
    val releaseDate: String
)
