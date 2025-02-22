

package com.bhiapps.cricutandroidquiz.views.playingGameGroup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalConfiguration
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.subviews.LandscapeLayout
import com.bhiapps.cricutandroidquiz.views.subviews.PortraitLayout

@Composable
fun PlayingGameView(
    viewStateVM: ViewStateViewModel,
    quizVM: QuizViewModel
) {
    val questionIndex by quizVM.currentQuestionIndex.collectAsState()
    val booleanAnswer by quizVM.selectedBooleanAnswer.collectAsState()
    val multipleChoiceAnswers by quizVM.selectedMultipleChoiceAnswers.collectAsState()
    val singleChoiceAnswer by quizVM.selectedSingleChoiceAnswer.collectAsState()
    val fillInTheBlankAnswer by quizVM.fillInTheBlankAnswer.collectAsState()
    val currentScore by quizVM.currentScore.collectAsState()

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    if (isLandscape) {
        LandscapeLayout(
            questionIndex,
            quizVM,
            booleanAnswer,
            multipleChoiceAnswers,
            singleChoiceAnswer,
            fillInTheBlankAnswer,
            currentScore,
            onNextQuestion = {
                quizVM.nextQuestion { viewStateVM.setViewState(ViewState.GAME_OVER) }
            }
        )
    } else {
        PortraitLayout(
            questionIndex,
            quizVM,
            booleanAnswer,
            multipleChoiceAnswers,
            singleChoiceAnswer,
            fillInTheBlankAnswer,
            currentScore,
            onNextQuestion = {
                quizVM.nextQuestion { viewStateVM.setViewState(ViewState.GAME_OVER) }
            }
        )
    }
}