package com.marryting.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography

@Composable
fun MarrytingTextField(modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, onValueClear: () -> Unit, isActive: Boolean, isError: Boolean, label: String, placeholder: String) {
    val currentColor = if (isActive) {
        DarkColor.SubGreen
    } else if (isError) {
        DarkColor.ErrorRed
    } else {
        DarkColor.Grey400
    }

    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .then(
                    if (isActive || isError) {
                        Modifier.border(1.dp, currentColor, RoundedCornerShape(8.dp))
                    } else {
                        Modifier
                    }
                )
                .background(DarkColor.Grey700, RoundedCornerShape(8.dp))
                .padding(horizontal = 20.dp, vertical = 14.dp)
        ) {
            Column(modifier = Modifier) {
                Text(
                    text = label,
                    style = KoreaTypography.caption,
                    color = currentColor
                )
                BasicTextField(
                    value = value,
                    onValueChange = onValueChanged,
                    textStyle = KoreaTypography.subtitle1.copy(color = Color.White),
                    singleLine = true,
                    cursorBrush = SolidColor(DarkColor.Grey400),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = KoreaTypography.subtitle1,
                                color = DarkColor.Grey400
                            )
                        } else {
                            innerTextField()
                        }
                    }
                )
            }
            if (value.isNotEmpty()) {
                Box(
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    if (isError) {
                        ErrorIcon()
                    } else {
                        CloseButton(modifier = modifier) { onValueClear() }
                    }
                }
            }
        }

        if (isError) {
            Box(
                modifier = Modifier.padding(top = 4.dp, start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "error message",
                    style = KoreaTypography.caption,
                    color = currentColor
                )
            }
        }
    }
}

@Composable
fun CloseButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier.clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            tint = DarkColor.Grey400
        )
    }
}

@Composable
fun ErrorIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_error),
        contentDescription = null,
        tint = DarkColor.ErrorRed
    )
}

@Preview
@Composable
fun Prev() {
    var text by remember { mutableStateOf("") }
    MarrytingTextField(
        value = text,
        onValueChanged = { if (text.length <= 5) text = it },
        onValueClear = { text = "" },
        isActive = false,
        isError = true,
        label = "이름",
        placeholder = "이름을 입력해주세요"
    )
}
