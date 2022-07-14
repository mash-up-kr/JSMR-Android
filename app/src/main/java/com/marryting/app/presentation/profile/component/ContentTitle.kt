package com.marryting.app.presentation.profile.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.LightColor

@Composable
fun ContentTitle(
    modifier: Modifier = Modifier,
    title: List<String>
) {
    Box(modifier = modifier) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 33.6.sp)) {
                    setWithStyle(Color.White, title[0])
                    setWithStyle(DarkColor.SubGreen, title[1])
                    setWithStyle(Color.White, title[2])
                }
            }
        )
    }
}

private fun AnnotatedString.Builder.setWithStyle(
    color: androidx.compose.ui.graphics.Color,
    title: String
) {
    fun getSpanStyle(color: androidx.compose.ui.graphics.Color): SpanStyle = SpanStyle(
        fontWeight = FontWeight.Bold,
        color = color,
        fontSize = 24.sp
    )

    withStyle(
        style = getSpanStyle(color)
    ) {
        append(title)
    }
}

@Composable
fun ContentDescription(
    description: String
) {
    Text(
        text = description,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = LightColor.Grey300
    )
}
