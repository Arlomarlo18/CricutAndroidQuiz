package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel

@Composable
fun LandscapeLayout(
    questionIndex: Int,
    quizVM: QuizViewModel,
    booleanAnswer: Boolean?,
    multipleChoiceAnswers: List<String>,
    singleChoiceAnswer: String?,
    fillInTheBlankAnswer: String,
    currentScore: Int,
    onNextQuestion: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                QuestionContent(quizVM, questionIndex, booleanAnswer, multipleChoiceAnswers, singleChoiceAnswer, fillInTheBlankAnswer)
            }
        }

        Column(
            modifier = Modifier.weight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ScoreHeader(currentScore)

            NextButton(
                questionIndex = questionIndex,
                totalQuestions = quizVM.questions.size
            ) {
                onNextQuestion()
            }
        }
    }
}
