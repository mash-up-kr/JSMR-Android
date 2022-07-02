package com.marryting.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marryting.app.R

@Composable
fun MarrytingButton(
    modifier: Modifier = Modifier,
    text: String = "",
    buttonType: MarrytingButton,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = buttonType.backgroundAndArrowColor),
        onClick = { onClick() }
    ) {
        if (buttonType is MarrytingButton.LeftArrow) {
            MarrytingButtonArrow(buttonType = buttonType)
        }

        Text(
            text = text,
            modifier = Modifier.padding(buttonType.paddingValues),
            color = buttonType.textAndCircleColor
        )

        if (buttonType is MarrytingButton.RightArrow) {
            MarrytingButtonArrow(buttonType = buttonType)
        }
    }
}

@Composable
private fun MarrytingButtonArrow(
    buttonType: MarrytingButton
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(buttonType.textAndCircleColor, RoundedCornerShape(40.dp)),
        contentAlignment = Alignment.Center
    ) {

        val painter: Int = if (buttonType is MarrytingButton.LeftArrow) {
            R.drawable.ic_arrow_left
        } else {
            R.drawable.ic_arrow_right
        }

        Image(
            painter = painterResource(id = painter),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = buttonType.backgroundAndArrowColor)
        )
    }
}

sealed class MarrytingButton(
    open val textAndCircleColor: Color, // 텍스트, 원 동일
    open val backgroundAndArrowColor: Color, // 백그라운드 화살표 동일
    open val paddingValues: PaddingValues
) {
    data class LeftArrow(
        override val textAndCircleColor: Color,
        override val backgroundAndArrowColor: Color,
        override val paddingValues: PaddingValues = PaddingValues(start = 22.dp)
    ) : MarrytingButton(textAndCircleColor, backgroundAndArrowColor, paddingValues)

    data class RightArrow(
        override val textAndCircleColor: Color,
        override val backgroundAndArrowColor: Color,
        override val paddingValues: PaddingValues = PaddingValues(end = 22.dp)
    ) : MarrytingButton(textAndCircleColor, backgroundAndArrowColor, paddingValues)
}
