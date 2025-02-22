package com.bhiapps.cricutandroidquiz.views.playingGameGroup.questionViews

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhiapps.cricutandroidquiz.models.objects.Question
import com.bhiapps.cricutandroidquiz.views.subviews.AutoResizedText

@Composable
fun BooleanQuestionView(
    question: Question.BooleanChoice,
    selectedAnswer: Boolean?,
    onAnswerSelected: (Boolean) -> Unit
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.padding(8.dp),
                onClick = { onAnswerSelected(true) },
                border = BorderStroke(
                    width = 2.dp,
                    color = if (selectedAnswer == true) Color.Green else Color.Transparent
                )
            ) {
                AutoResizedText(
                    modifier = Modifier.padding(8.dp),
                    text = "True",
                    softWrap = false,
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Card(
                modifier = Modifier.padding(8.dp),
                onClick = { onAnswerSelected(false) },
                border = BorderStroke(
                    width = 2.dp,
                    color = if (selectedAnswer == false) Color.Green else Color.Transparent
                )
            ) {
                AutoResizedText(
                    modifier = Modifier.padding(8.dp),
                    text = "False",
                    softWrap = false,
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}