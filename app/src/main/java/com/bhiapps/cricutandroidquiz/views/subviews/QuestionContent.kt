package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.runtime.Composable
import com.bhiapps.cricutandroidquiz.models.objects.Question
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.BooleanQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.FillInTheBlankQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.MultipleChoiceQuestionView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews.SingleChoiceQuestionView

@Composable
fun QuestionContent(
    quizVM: QuizViewModel,
    questionIndex: Int,
    booleanAnswer: Boolean?,
    multipleChoiceAnswers: List<String>,
    singleChoiceAnswer: String?,
    fillInTheBlankAnswer: String
) {
    when (val question = quizVM.questions[questionIndex]) {
        is Question.SingleChoice -> {
            SingleChoiceQuestionView(
                question = question,
                selectedAnswer = singleChoiceAnswer,
                onAnswerSelected = { quizVM.setSingleChoiceAnswer(it) }
            )
        }

        is Question.MultipleChoice -> {
            MultipleChoiceQuestionView(
                question = question,
                selectedAnswers = multipleChoiceAnswers,
                onAnswerSelected = { quizVM.setMultipleChoiceAnswer(it) },
                onAnswerRemoved = { quizVM.removeMultipleChoiceAnswer(it) }
            )
        }

        is Question.BooleanChoice -> {
            BooleanQuestionView(
                question = question,
                selectedAnswer = booleanAnswer,
                onAnswerSelected = { quizVM.setBooleanAnswer(it) }
            )
        }

        is Question.FillInTheBlank -> {
            FillInTheBlankQuestionView(
                question = question,
                selectedAnswer = fillInTheBlankAnswer,
                onAnswerSelected = { quizVM.setFillInTheBlankAnswer(it) }
            )
        }
    }
}