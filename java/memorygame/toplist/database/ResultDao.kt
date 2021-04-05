package hu.bme.aut.android.memorygame.toplist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ResultDao {

    @Insert
    fun insertResult(result: RoomResult)

    @Query("SELECT * FROM toplist")
    fun getAllResult(): LiveData<List<RoomResult>>

    @Query("SELECT * FROM toplist WHERE mode == :mode")
    fun getTodoByMode(mode: String?): RoomResult?

    @Update
    fun updateResult(todo: RoomResult): Int

    @Delete
    fun deleteResult(todo: RoomResult)

    @Query("DELETE FROM toplist")
    fun clearAllTables()

}