package com.marryting.app.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.ui.theme.EnglishTypography

fun Modifier.noRippleClickable(interactionSource: MutableInteractionSource, enabled: Boolean, onClick: () -> Unit): Modifier = clickable(
    indication = null,
    interactionSource = interactionSource,
    enabled = enabled,
    onClick = onClick
)

@Composable
fun MarrytingButton(modifier: Modifier = Modifier, text: String = "", enabled: Boolean = false, buttonType: MarrytingButtonType, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val colorSet = if (!enabled && buttonType is MarrytingButtonType.RightArrow) {
        buttonType.disabledColorSet
    } else if (isPressed) {
        buttonType.pressedColorSet
    } else {
        buttonType.activeColorSet
    }

    Row(
        modifier = modifier
            .background(colorSet.backgroundColor, RoundedCornerShape(40.dp))
            .noRippleClickable(
                interactionSource = interactionSource,
                enabled = enabled,
                onClick = onClick
            )
            .padding(vertical = 8.dp)
            .padding(buttonType.contentPaddingValues),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (buttonType is MarrytingButtonType.LeftArrow) {
            MarrytingButtonArrow(buttonType = buttonType, colorSet = colorSet)
        }

        Text(
            text = text,
            color = colorSet.contentColor,
            style = EnglishTypography.subtitle1
        )

        if (buttonType is MarrytingButtonType.RightArrow) {
            MarrytingButtonArrow(
                modifier = Modifier.padding(start = 22.dp),
                buttonType = buttonType,
                colorSet = colorSet
            )
        }
    }
}

@Composable
private fun MarrytingButtonArrow(modifier: Modifier = Modifier, buttonType: MarrytingButtonType, colorSet: MarrytingButtonColorSet) {
    val painter: Int = if (buttonType is MarrytingButtonType.LeftArrow) {
        R.drawable.ic_arrow_left
    } else {
        R.drawable.ic_arrow_right
    }

    val circleColor = if (buttonType is MarrytingButtonType.LeftArrow) {
        colorSet.backgroundColor
    } else {
        colorSet.contentColor
    }

    Box(
        modifier = modifier
            .size(40.dp)
            .background(circleColor, RoundedCornerShape(40.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = colorSet.arrowColor)
        )
    }
}

@Composable
fun MarrytingIconButton(modifier: Modifier = Modifier, enabled: Boolean = true, buttonType: MarrytingButtonType, onClick: () -> Unit, @DrawableRes drawableRes: Int) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val colorSet = if (!enabled && buttonType is MarrytingButtonType.Icon) {
        buttonType.disabledColorSet
    } else if (isPressed) {
        buttonType.pressedColorSet
    } else {
        buttonType.activeColorSet
    }

    Box(
        modifier = modifier
            .size(48.dp)
            .background(colorSet.backgroundColor, RoundedCornerShape(30.dp))
            .noRippleClickable(
                interactionSource = interactionSource,
                enabled = enabled,
                onClick = onClick
            )
            .padding(buttonType.contentPaddingValues)
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = drawableRes),
            contentDescription = null,
            tint = colorSet.contentColor
        )
    }
}
