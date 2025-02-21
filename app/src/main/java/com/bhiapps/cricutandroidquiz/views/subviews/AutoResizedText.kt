package com.bhiapps.cricutandroidquiz.views.subviews

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.isUnspecified


/**
 * A Jetpack Compose composable that automatically resizes text to fit within its bounds.
 *
 * This ensures that text does not overflow its container by dynamically adjusting
 * the font size while maintaining readability.
 *
 * @param modifier The modifier to apply to this layout.
 * @param text The text to be displayed.
 * @param style The text style (font size, weight, etc.), defaults to `headlineLarge` from MaterialTheme.
 * @param softWrap Whether the text should wrap when it overflows its container, defaults to `false`.
 * @param color The color of the text. Defaults to `Color.Unspecified`, which uses the theme's default text color.
 */
@Composable
fun AutoResizedText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.headlineLarge,
    softWrap: Boolean = false,
    color: Color = Color.Unspecified
) {
    var resizedTextStyle by remember { mutableStateOf(style) }

    var shouldDraw by remember { mutableStateOf(false) }

    val defaultFontSize = MaterialTheme.typography.headlineLarge.fontSize

    Text(
        modifier = modifier
            .drawWithContent {
                if (shouldDraw) {
                    drawContent()
                }
            },
        text = text,
        color = color,
        softWrap = softWrap,
        style = resizedTextStyle,
        onTextLayout = { result ->
            if (result.didOverflowWidth) {
                if (style.fontSize.isUnspecified) {
                    resizedTextStyle = resizedTextStyle.copy(
                        fontSize = defaultFontSize
                    )
                }
            }

            if (result.didOverflowWidth) {
                resizedTextStyle = resizedTextStyle.copy(fontSize = resizedTextStyle.fontSize * 0.95f)
            } else {
                shouldDraw = true
            }
        }
    )
}