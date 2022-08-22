package com.marryting.app.presentation.profile.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.marryting.app.component.setWithStyle
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography
import com.ui.theme.LightColor

@Composable
fun RegisterContentTitle(modifier: Modifier = Modifier, title: List<String>) {
    Box(modifier = modifier) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 33.6.sp)) {
                    setWithStyle(Color.White, KoreaTypography.headline3, title[0])
                    setWithStyle(DarkColor.SubGreen, KoreaTypography.headline3, title[1])
                    setWithStyle(Color.White, KoreaTypography.headline3, title[2])
                }
            }
        )
    }
}

@Composable
fun RegisterContentDescription(description: String) {
    Text(
        text = description,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = LightColor.Grey300
    )
}
