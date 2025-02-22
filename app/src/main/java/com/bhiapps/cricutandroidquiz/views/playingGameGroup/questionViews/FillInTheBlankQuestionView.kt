package com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.models.objects.Question
import com.bhiapps.cricutandroidquiz.views.subviews.AutoResizedText

@Composable
fun FillInTheBlankQuestionView(
    question: Question.FillInTheBlank,
    selectedAnswer: String,
    onAnswerSelected: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AutoResizedText(
            modifier = Modifier.padding(16.dp),
            text = question.question,
            softWrap = true,
            style = TextStyle(
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        )

        OutlinedTextField(
            value = selectedAnswer,
            onValueChange = { onAnswerSelected(it)},
            label = { AutoResizedText(text = "Answer") }
        )
    }
}