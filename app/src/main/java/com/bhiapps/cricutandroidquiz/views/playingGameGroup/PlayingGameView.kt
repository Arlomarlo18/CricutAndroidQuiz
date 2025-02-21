package com.bhiapps.cricutandroidquiz.views.playingGameGroup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
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
fun PlayingGameView(
    viewStateVM: ViewStateViewModel,
    quizVM: QuizViewModel
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AutoResizedText(
            modifier = Modifier,
            text = "Playing Game",
            softWrap = false,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                viewStateVM.setViewState(ViewState.GAME_OVER)
            }
        ) {
            AutoResizedText(
                modifier = Modifier,
                text = "Game Over",
                softWrap = false,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}