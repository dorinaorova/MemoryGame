package hu.bme.aut.android.memorygame.toplist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.bme.aut.android.memorygame.toplist.ResultApplication
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import hu.bme.aut.android.memorygame.toplist.repository.Repository
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {

    private val repository: Repository

    val allResults: LiveData<List<ResultGame>>

    init {
        val resultDao = ResultApplication.resultDatabase.resultDao()
        repository = Repository(resultDao)
        allResults = repository.getAllResults()
    }

    fun insert(result: ResultGame) = viewModelScope.launch {
        repository.insert(result)
    }

}