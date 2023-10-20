package id.novian.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.novian.common.data.local.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}