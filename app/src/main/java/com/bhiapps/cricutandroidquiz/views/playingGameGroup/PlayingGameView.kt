package com.bhiapps.cricutandroidquiz.views.playingGameGroup

import android.widget.ScrollView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.R
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import com.bhiapps.cricutandroidquiz.models.objects.Question
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.BooleanQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.FillInTheBlankQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.MultipleChoiceQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.SingleChoiceQuestionView
import com.bhiapps.cricutandroidquiz.views.subviews.AutoResizedText

@Composable
fun PlayingGameView(
    viewStateVM: ViewStateViewModel,
    quizVM: QuizViewModel
) {

    val questionIndex by quizVM.currentQuestionIndex.collectAsState()
    val booleanAnswer by quizVM.selectedBooleanAnswer.collectAsState()
    val multipleChoiceAnswers by quizVM.selectedMultipleChoiceAnswers.collectAsState()
    val singleChoiceAnswers by quizVM.selectedSingleChoiceAnswer.collectAsState()
    val fillInTheBlankAnswer by quizVM.fillInTheBlankAnswer.collectAsState()
    val currentScore by quizVM.currentScore.collectAsState()

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp


    if (!isLandscape) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                AutoResizedText(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(R.string.playing_game),
                    softWrap = false,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                )

                AutoResizedText(
                    modifier = Modifier.padding(16.dp),
                    text = currentScore.toString(),
                    softWrap = false,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                )

                when (quizVM.questions[questionIndex]) {
                    is Question.SingleChoice -> {
                        SingleChoiceQuestionView(
                            quizVM.questions[questionIndex] as Question.SingleChoice,
                            selectedAnswer = singleChoiceAnswers,
                            onAnswerSelected = { quizVM.setSingleChoiceAnswer(it) }
                        )
                    }

                    is Question.MultipleChoice -> {
                        MultipleChoiceQuestionView(
                            quizVM.questions[questionIndex] as Question.MultipleChoice,
                            selectedAnswers = multipleChoiceAnswers,
                            onAnswerSelected = { quizVM.setMultipleChoiceAnswer(it) },
                            onAnswerRemoved = { quizVM.removeMultipleChoiceAnswer(it) }
                        )
                    }

                    is Question.BooleanChoice -> {
                        BooleanQuestionView(
                            quizVM.questions[questionIndex] as Question.BooleanChoice,
                            selectedAnswer = booleanAnswer,
                            onAnswerSelected = { quizVM.setBooleanAnswer(it) }
                        )
                    }

                    is Question.FillInTheBlank -> {
                        FillInTheBlankQuestionView(
                            quizVM.questions[questionIndex] as Question.FillInTheBlank,
                            selectedAnswer = fillInTheBlankAnswer,
                            onAnswerSelected = { quizVM.setFillInTheBlankAnswer(it) }
                        )
                    }
                }

                Button(
                    modifier = Modifier.padding(24.dp),
                    onClick = {
                        quizVM.nextQuestion() {
                            viewStateVM.setViewState(ViewState.GAME_OVER)
                        }
                    }
                ) {
                    AutoResizedText(
                        modifier = Modifier,
                        text = if (questionIndex < quizVM.questions.size - 1) stringResource(R.string.next) else stringResource(
                            R.string.finish
                        ),
                        softWrap = false,
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 32.sp
                        )
                    )
                }
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            LazyColumn(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    when (quizVM.questions[questionIndex]) {
                        is Question.SingleChoice -> {
                            SingleChoiceQuestionView(
                                quizVM.questions[questionIndex] as Question.SingleChoice,
                                selectedAnswer = singleChoiceAnswers,
                                onAnswerSelected = { quizVM.setSingleChoiceAnswer(it) }
                            )
                        }

                        is Question.MultipleChoice -> {
                            MultipleChoiceQuestionView(
                                quizVM.questions[questionIndex] as Question.MultipleChoice,
                                selectedAnswers = multipleChoiceAnswers,
                                onAnswerSelected = { quizVM.setMultipleChoiceAnswer(it) },
                                onAnswerRemoved = { quizVM.removeMultipleChoiceAnswer(it) }
                            )
                        }

                        is Question.BooleanChoice -> {
                            BooleanQuestionView(
                                quizVM.questions[questionIndex] as Question.BooleanChoice,
                                selectedAnswer = booleanAnswer,
                                onAnswerSelected = { quizVM.setBooleanAnswer(it) }
                            )
                        }

                        is Question.FillInTheBlank -> {
                            FillInTheBlankQuestionView(
                                quizVM.questions[questionIndex] as Question.FillInTheBlank,
                                selectedAnswer = fillInTheBlankAnswer,
                                onAnswerSelected = { quizVM.setFillInTheBlankAnswer(it) }
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.weight(0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AutoResizedText(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(R.string.playing_game),
                    softWrap = false,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                )

                AutoResizedText(
                    modifier = Modifier.padding(16.dp),
                    text = currentScore.toString(),
                    softWrap = false,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp
                    )
                )

                Button(
                    modifier = Modifier.padding(24.dp),
                    onClick = {
                        quizVM.nextQuestion() {
                            viewStateVM.setViewState(ViewState.GAME_OVER)
                        }
                    }
                ) {
                    AutoResizedText(
                        modifier = Modifier,
                        text = if (questionIndex < quizVM.questions.size - 1) stringResource(R.string.next) else stringResource(R.string.finish),
                        softWrap = false,
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 32.sp
                        )
                    )
                }
            }
        }
    }
}