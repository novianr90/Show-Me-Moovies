package id.novian.common.data.mapper

import id.novian.common.data.local.model.MovieEntity
import id.novian.common.domain.model.Movie
import id.novian.common.domain.model.MovieDetails
import id.novian.common.network.dto.Result
import id.novian.common.network.dto.single.SingleMovieResponse

fun Result.toDomain(): Movie {
    return Movie(
        id = this.id,
        title = this.originalTitle,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        overview = this.overview,
        releaseDate = this.releaseDate
    )
}

fun SingleMovieResponse.toDomain(): MovieDetails {
    val listOfGenre = this.genres.map { it.name }
    return MovieDetails(
        id = this.id,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        genres = listOfGenre,
        releaseDate = this.releaseDate,
        runtime = this.runtime,
        revenue = this.revenue,
        status = this.status,
        tagline = this.tagline,
        favorites = false
    )
}

fun MovieDetails.toEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        originalTitle = this.originalTitle,
        overview = this.overview,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        releaseDate = this.releaseDate,
        status = this.status,
        tagline = this.tagline
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = this.id,
        title = this.originalTitle,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        overview = this.overview,
        releaseDate = this.releaseDate
    )
}