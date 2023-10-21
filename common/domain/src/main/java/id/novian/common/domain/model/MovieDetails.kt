package id.novian.common.domain.model

data class MovieDetails(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val backdropPath: String,
    val genres: List<String>,
    val releaseDate: String,
    val runtime: Int,
    val revenue: Int,
    val status: String,
    val tagline: String,
    val favorites: Boolean
)
