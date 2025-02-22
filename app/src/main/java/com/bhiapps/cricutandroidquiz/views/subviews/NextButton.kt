package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.R

@Composable
fun NextButton(questionIndex: Int, totalQuestions: Int, onNextQuestion: () -> Unit) {
    Button(
        modifier = Modifier.padding(24.dp),
        onClick = onNextQuestion
    ) {
        AutoResizedText(
            text = if (questionIndex < totalQuestions - 1) stringResource(R.string.next) else stringResource(
                R.string.finish),
            softWrap = false,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
        )
    }
}