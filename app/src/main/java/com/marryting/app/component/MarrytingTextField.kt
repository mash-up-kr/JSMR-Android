package com.marryting.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.marryting.app.presentation.profile.register.UserInfoItemState
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography

@Composable
fun Container(modifier: Modifier = Modifier, state: UserInfoItemState, label: String, containerItem: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .height(79.dp)
            .fillMaxWidth()
            .then(
                when (state) {
                    UserInfoItemState.BASIC -> Modifier
                    else -> Modifier.border(1.dp, state.color, RoundedCornerShape(8.dp))
                }
            )
            .background(DarkColor.Grey700, RoundedCornerShape(8.dp))
            .padding(horizontal = 20.dp, vertical = 14.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.Center)) {
            Text(
                text = label,
                style = KoreaTypography.caption,
                color = state.color
            )
            containerItem()
        }
    }
}

@Composable
fun MarrytingTextField(modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, onValueClear: () -> Unit, state: UserInfoItemState, label: String, placeholder: String) {
    Column(
        modifier = modifier
    ) {
        Container(state = state, label = label) {
            TextFieldItem(
                value = value,
                onValueChanged = onValueChanged,
                onValueClear = onValueClear,
                state = state,
                placeholder = placeholder
            )
        }

        if (state == UserInfoItemState.ERROR) {
            Box(
                modifier = Modifier.padding(top = 4.dp, start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "error message",
                    style = KoreaTypography.caption,
                    color = state.color
                )
            }
        }
    }
}

@Composable
fun TextFieldItem(value: String, onValueChanged: (String) -> Unit, onValueClear: () -> Unit, state: UserInfoItemState, placeholder: String) {
    Box {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChanged,
            textStyle = KoreaTypography.subtitle1.copy(color = Color.White),
            maxLines = 1,
            singleLine = true,
            cursorBrush = SolidColor(DarkColor.Grey400),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    PlaceHolder(placeholder = placeholder, color = DarkColor.Grey400)
                } else {
                    innerTextField()
                }
            }
        )
        if (value.isNotEmpty()) {
            Box(
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                when (state) {
                    UserInfoItemState.ERROR -> ErrorIcon()
                    else -> CloseButton { onValueClear() }
                }
            }
        }
    }
}

@Composable
fun PlaceHolder(modifier: Modifier = Modifier, placeholder: String, color: androidx.compose.ui.graphics.Color) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = placeholder,
        style = KoreaTypography.subtitle1,
        color = color
    )
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
        state = UserInfoItemState.ERROR,
        label = "이름",
        placeholder = "이름을 입력해주세요"
    )
}
