package com.marryting.app.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ui.theme.DarkColor

data class MarrytingButtonColorSet(
    val contentColor: Color,
    val backgroundColor: Color,
    val arrowColor: Color = backgroundColor
)

sealed class MarrytingButtonType(
    open val activeColorSet: MarrytingButtonColorSet,
    open val pressedColorSet: MarrytingButtonColorSet,
    open val disabledColorSet: MarrytingButtonColorSet?,
    open val contentPaddingValues: PaddingValues
) {
    data class LeftArrow(
        override val activeColorSet: MarrytingButtonColorSet,
        override val pressedColorSet: MarrytingButtonColorSet,
        override val contentPaddingValues: PaddingValues = PaddingValues(start = 8.dp, end = 24.dp)
    ) : MarrytingButtonType(activeColorSet, pressedColorSet, null, contentPaddingValues)

    data class RightArrow(
        override val activeColorSet: MarrytingButtonColorSet,
        override val pressedColorSet: MarrytingButtonColorSet,
        override val disabledColorSet: MarrytingButtonColorSet,
        override val contentPaddingValues: PaddingValues = PaddingValues(start = 36.dp, end = 8.dp)
    ) : MarrytingButtonType(activeColorSet, pressedColorSet, disabledColorSet, contentPaddingValues)

    data class Icon(
        override val activeColorSet: MarrytingButtonColorSet,
        override val pressedColorSet: MarrytingButtonColorSet,
        override val disabledColorSet: MarrytingButtonColorSet = MarrytingButtonColorSet(contentColor = DarkColor.Grey200, backgroundColor = DarkColor.Grey700),
        override val contentPaddingValues: PaddingValues
    ) : MarrytingButtonType(activeColorSet, pressedColorSet, disabledColorSet, contentPaddingValues)
}
