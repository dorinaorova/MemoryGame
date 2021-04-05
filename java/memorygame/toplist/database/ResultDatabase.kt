package hu.bme.aut.android.memorygame.toplist.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    exportSchema = false,
    entities = [RoomResult::class]
)

abstract class ResultDatabase : RoomDatabase() {

    abstract fun resultDao(): ResultDao

}