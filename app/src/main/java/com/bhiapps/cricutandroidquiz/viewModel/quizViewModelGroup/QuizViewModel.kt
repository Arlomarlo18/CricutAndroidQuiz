package com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhiapps.cricutandroidquiz.models.objects.Question
import com.bhiapps.cricutandroidquiz.models.objects.loadQuestions
import com.bhiapps.cricutandroidquiz.utils.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class QuizViewModel(
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    private val _highScore = MutableStateFlow(0)
    val highScore = _highScore.asStateFlow()

    private val _currentScore = MutableStateFlow(0)
    val currentScore = _currentScore.asStateFlow()

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex = _currentQuestionIndex.asStateFlow()

    private val _selectedBooleanAnswer = MutableStateFlow<Boolean?>(null)
    val selectedBooleanAnswer = _selectedBooleanAnswer.asStateFlow()

    private val _selectedMultipleChoiceAnswers = MutableStateFlow<MutableList<String>>(mutableListOf())
    val selectedMultipleChoiceAnswers = _selectedMultipleChoiceAnswers.asStateFlow()

    private val _selectedSingleChoiceAnswer = MutableStateFlow<String?>(null)
    val selectedSingleChoiceAnswer = _selectedSingleChoiceAnswer.asStateFlow()

    private val _fillInTheBlankAnswer = MutableStateFlow<String>("")
    val fillInTheBlankAnswer = _fillInTheBlankAnswer.asStateFlow()

    var questions = listOf<Question>()

    init {
        getHighScore()
        setQuestions()
    }

    // User Intents
    private fun addPoint() {
        _currentScore.value += 1
    }

    private fun minusPoint() {
        _currentScore.value -= 1
    }

    fun nextQuestion(changeViewState: () -> Unit) {
        if (_currentQuestionIndex.value < questions.size - 1 ) {
            answerQuestion()
            resetFillInTheBlankAnswer()
            resetSingleChoiceAnswer()
            resetMultipleChoiceAnswer()
            resetBooleanAnswer()
            _currentQuestionIndex.value += 1
        } else {
            answerQuestion()
            changeViewState()
            setQuestions()
            updateHighScore(_currentScore.value)
        }
    }

    private fun answerQuestion() {
        when (questions[_currentQuestionIndex.value]) {
            is Question.BooleanChoice -> {
                val question = questions[_currentQuestionIndex.value] as Question.BooleanChoice
                if (question.answer == _selectedBooleanAnswer.value) addPoint() else minusPoint()
            }
            is Question.MultipleChoice -> {
                val question = questions[_currentQuestionIndex.value] as Question.MultipleChoice
                if (_selectedMultipleChoiceAnswers.value.toSet() == question.answer.toSet()) addPoint() else minusPoint()
            }
            is Question.SingleChoice -> {
                val question = questions[_currentQuestionIndex.value] as Question.SingleChoice
                if (question.answer == _selectedSingleChoiceAnswer.value) addPoint() else minusPoint()
            }
            is Question.FillInTheBlank -> {
                val question = questions[_currentQuestionIndex.value] as Question.FillInTheBlank
                if (question.answer.lowercase(Locale.ROOT) == _fillInTheBlankAnswer.value.lowercase(Locale.ROOT)) addPoint() else minusPoint()
            }
        }
    }

    // Boolean Logic
    fun setBooleanAnswer(answer: Boolean) {
        _selectedBooleanAnswer.value = answer
    }

    private fun resetBooleanAnswer() {
        _selectedBooleanAnswer.value = null
    }

    // Multiple Choice Logic
    fun setMultipleChoiceAnswer(answer: String) {
        _selectedMultipleChoiceAnswers.value = (_selectedMultipleChoiceAnswers.value + answer).toMutableList()
        println(_selectedMultipleChoiceAnswers.value)
    }

    fun removeMultipleChoiceAnswer(answer: String) {
        _selectedMultipleChoiceAnswers.value = (_selectedMultipleChoiceAnswers.value - answer).toMutableList()
        println(_selectedMultipleChoiceAnswers.value)
    }

    // Single Choice Logic
    fun setSingleChoiceAnswer(answer: String) {
        _selectedSingleChoiceAnswer.value = answer
    }

    private fun resetSingleChoiceAnswer() {
        _selectedSingleChoiceAnswer.value = null
    }

    private fun resetMultipleChoiceAnswer() {
        _selectedMultipleChoiceAnswers.value = mutableListOf()
    }

    // Fill In The Blank Logic
    fun setFillInTheBlankAnswer(answer: String) {
        _fillInTheBlankAnswer.value = answer
    }

    private fun resetFillInTheBlankAnswer() {
        _fillInTheBlankAnswer.value = ""
    }

    // Game Logic
    private fun setQuestions() {
        questions = loadQuestions().shuffled()
    }

    private fun updateHighScore(score: Int) {
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

    fun resetGame() {
        _currentScore.value = 0
        _currentQuestionIndex.value = 0
    }
}