package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScoreHeader(currentScore: Int) {
    AutoResizedText(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        text = "Score: $currentScore",
        softWrap = false,
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
    )
}