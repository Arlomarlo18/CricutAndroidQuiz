package com.bhiapps.cricutandroidquiz.views.gameOverView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.subviews.AutoResizedText

@Composable
fun GameOverView(
    viewStateVM: ViewStateViewModel,
    quizVM: QuizViewModel
) {

    val highScore by quizVM.highScore.collectAsState()
    val currentScore by quizVM.currentScore.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AutoResizedText(
            modifier = Modifier,
            text = "High Score: $highScore",
            softWrap = false,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
        )

        AutoResizedText(
            modifier = Modifier,
            text = "Current Score: $currentScore",
            softWrap = false,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
        )

        Button(
            onClick = {
                quizVM.resetGame()
                viewStateVM.setViewState(ViewState.START_GAME)
            }
        ) {
            AutoResizedText(
                modifier = Modifier,
                text = "Return to Start",
                softWrap = false,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp
                )
            )
        }
    }
}