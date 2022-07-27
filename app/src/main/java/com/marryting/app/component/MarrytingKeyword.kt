package com.marryting.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ui.theme.DarkColor
import com.ui.theme.DarkColor.Main300
import com.ui.theme.DarkColor.SubBlue
import com.ui.theme.DarkColor.SubGreen
import com.ui.theme.DarkColor.SubPurple
import com.ui.theme.DarkColor.SubYellow
import com.ui.theme.KoreaTypography

// HELP ME PLEASE.....
val selectedItemColor = listOf<Color>(Main300, SubPurple, SubYellow, SubBlue, SubGreen)

@Composable
fun MarrytingKeyword(modifier: Modifier = Modifier, value: String, selectedItemList: List<String> = emptyList(), onSelected: (String) -> Unit, onCanceled: (String) -> Unit) {
    val isSelectedItem = value in selectedItemList

    val borderColor = if (isSelectedItem) {
        selectedItemColor[selectedItemList.indexOf(value)]
    } else {
        DarkColor.Grey500
    }

    val backgroundColor = if (isSelectedItem) {
        borderColor.copy(alpha = 0.16f)
    } else {
        DarkColor.Grey700
    }

    Box(
        modifier = modifier
            .height(40.dp)
            .border(1.dp, borderColor, RoundedCornerShape(30.dp))
            .background(backgroundColor, RoundedCornerShape(30.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                enabled = true,
                onClick = {
                    if (isSelectedItem) {
                        onCanceled(value)
                    } else {
                        onSelected(value)
                    }
                }
            )
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 7.dp, horizontal = 16.dp),
            text = value,
            style = if (isSelectedItem) {
                KoreaTypography.headline5
            } else {
                KoreaTypography.body1
            },
            color = if (isSelectedItem) {
                com.ui.theme.Color.White
            } else {
                DarkColor.Grey200
            }
        )
    }
}
