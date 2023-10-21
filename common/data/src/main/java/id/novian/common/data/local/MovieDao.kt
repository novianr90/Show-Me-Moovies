package id.novian.common.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.novian.common.data.local.model.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertId(movieEntity: MovieEntity)

    @Query("SELECT * FROM MovieEntity")
    suspend fun getListOfFavMovie(): List<MovieEntity>

    @Query("DELETE FROM MovieEntity WHERE id = :id")
    suspend fun deleteFavMovieId(id: Int)

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    suspend fun getMovieById(id: Int): List<MovieEntity>
}