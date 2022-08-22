package com.marryting.app.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ui.theme.Color
import com.ui.theme.EnglishTypography
import com.ui.theme.KoreaTypography
import com.ui.theme.LightColor

@Composable
fun MarrytingResultText(modifier: Modifier = Modifier, name: String, resultText: String) {
    Column(
        modifier = modifier
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 40.8.sp)) {
                    setWithStyle(LightColor.Main300, EnglishTypography.headline2, "Nice!\n")
                    setWithStyle(Color.DarkBackground, EnglishTypography.headline2, "Completed")
                }
            }
        )

        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    setWithStyle(LightColor.Grey500, KoreaTypography.headline4, name)
                    setWithStyle(LightColor.Grey500, KoreaTypography.headline4, resultText)
                }
            },
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

fun AnnotatedString.Builder.setWithStyle(color: androidx.compose.ui.graphics.Color, style: TextStyle, title: String) {
    fun getSpanStyle(color: androidx.compose.ui.graphics.Color): SpanStyle = SpanStyle(
        color = color,
        fontFamily = style.fontFamily,
        fontSize = style.fontSize,
        fontWeight = style.fontWeight
    )

    withStyle(
        style = getSpanStyle(color)
    ) {
        append(title)
    }
}
