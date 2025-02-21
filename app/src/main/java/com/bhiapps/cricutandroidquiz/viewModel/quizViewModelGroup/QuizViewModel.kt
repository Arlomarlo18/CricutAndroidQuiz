package com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhiapps.cricutandroidquiz.utils.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    private val _highScore = MutableStateFlow(0)
    val highScore = _highScore.asStateFlow()

    init {
        getHighScore()
    }

    fun updateHighScore(score: Int) {
        if (score > _highScore.value) {
            viewModelScope.launch(Dispatchers.IO) {
                dataStoreManager.saveNewHighScore(score)
                getHighScore()
            }
        }
    }

    private fun getHighScore() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreManager.highScore.collect { highScore ->
                _highScore.value = highScore
            }
        }
    }
}