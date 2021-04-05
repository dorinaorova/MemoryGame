package hu.bme.aut.android.memorygame.toplist

import android.app.Application
import androidx.room.Room
import hu.bme.aut.android.memorygame.toplist.database.ResultDatabase


class ResultApplication : Application() {

	companion object {
		lateinit var resultDatabase: ResultDatabase
	  		private set
	}

	override fun onCreate() {
		super.onCreate()

		resultDatabase = Room.databaseBuilder(
                    applicationContext,
                    ResultDatabase::class.java,
                    "todo_database"
                ).build()
	}

}