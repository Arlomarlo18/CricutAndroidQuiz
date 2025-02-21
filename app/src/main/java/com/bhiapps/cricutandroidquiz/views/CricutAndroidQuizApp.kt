package com.bhiapps.cricutandroidquiz.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import com.bhiapps.cricutandroidquiz.viewModel.quizViewModelGroup.QuizViewModel
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.gameOverView.GameOverView
import com.bhiapps.cricutandroidquiz.views.playingGameGroup.PlayingGameView
import com.bhiapps.cricutandroidquiz.views.startGameGroup.StartGameView


@Composable
fun CricutAndroidQuizApp(
    viewStateVM: ViewStateViewModel,
    quizVM: QuizViewModel
) {

    val viewState by viewStateVM.viewState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            when (viewState) {
                ViewState.START_GAME -> {
                    StartGameView(viewStateVM)
                }

                ViewState.PLAYING_GAME -> {
                    PlayingGameView(viewStateVM, quizVM)
                }

                ViewState.GAME_OVER -> {
                    GameOverView(viewStateVM, quizVM)
                }
            }
        }
    }
}