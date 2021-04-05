package hu.bme.aut.android.memorygame.toplist.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toplist")

data class RoomResult(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String?,
    val seconds: Int,
    val mode: String?
)