package id.novian.common.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val status: String,
    val tagline: String
)
