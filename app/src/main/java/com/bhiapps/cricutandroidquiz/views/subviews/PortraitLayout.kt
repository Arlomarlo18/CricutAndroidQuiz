package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel

@Composable
fun PortraitLayout(
    questionIndex: Int,
    quizVM: QuizViewModel,
    booleanAnswer: Boolean?,
    multipleChoiceAnswers: List<String>,
    singleChoiceAnswer: String?,
    fillInTheBlankAnswer: String,
    currentScore: Int,
    onNextQuestion: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScoreHeader(currentScore)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                QuestionContent(quizVM, questionIndex, booleanAnswer, multipleChoiceAnswers, singleChoiceAnswer, fillInTheBlankAnswer)
            }

            item {
                NextButton(
                    questionIndex = questionIndex,
                    totalQuestions = quizVM.questions.size
                ) {
                    onNextQuestion()
                }
            }
        }
    }
}