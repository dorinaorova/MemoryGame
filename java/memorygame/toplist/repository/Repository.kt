package hu.bme.aut.android.memorygame.toplist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import hu.bme.aut.android.memorygame.toplist.database.ResultDao
import hu.bme.aut.android.memorygame.toplist.database.RoomResult
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val resultDao: ResultDao) {

    fun getAllResults(): LiveData<List<ResultGame>> {
        return resultDao.getAllResult()
            .map {roomResults ->
                roomResults.map {roomResult ->
                    roomResult.toDomainModel() }
            }
    }

    suspend fun insert(result: ResultGame) = withContext(Dispatchers.IO) {
        resultDao.insertResult(result.toRoomModel())
    }

    suspend fun refresh(mode: String) = withContext(Dispatchers.IO) {
        resultDao.getTodoByMode(mode)
    }

    private fun RoomResult.toDomainModel(): ResultGame {
        return ResultGame(
            id = id,
            date=date,
            seconds=seconds,
            mode=mode
        )
    }

    private fun ResultGame.toRoomModel(): RoomResult {
        return RoomResult(
            date = date,
            seconds = seconds,
            mode=mode
        )
    }
}