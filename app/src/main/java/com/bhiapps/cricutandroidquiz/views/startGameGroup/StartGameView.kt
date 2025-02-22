package com.bhiapps.cricutandroidquiz.views.startGameGroup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.R
import com.bhiapps.cricutandroidquiz.models.enums.ViewState
import com.bhiapps.cricutandroidquiz.viewModel.viewStateViewModelGroup.ViewStateViewModel
import com.bhiapps.cricutandroidquiz.views.subviews.AutoResizedText

@Composable
fun StartGameView(viewStateVM: ViewStateViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        AutoResizedText(
            text = "Cricut Android Quiz",
            softWrap = true,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                viewStateVM.setViewState(ViewState.PLAYING_GAME)
            }
        ) {
            AutoResizedText(
                modifier = Modifier,
                text = stringResource(R.string.start_game),
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