package com.marryting.app.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.marryting.app.presentation.profile.UserInfoTextFieldState
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography

@Composable
fun Container(modifier: Modifier = Modifier, state: UserInfoTextFieldState, label: String, containerItem: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .heightIn(min = 79.dp)
            .fillMaxWidth()
            .then(
                when (state) {
                    UserInfoTextFieldState.Default() -> Modifier
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
fun MarrytingTextField(modifier: Modifier = Modifier, setUserInfoState: (String, UserInfoTextFieldState) -> Unit, value: String, onValueChanged: (String) -> Unit, onValueClear: () -> Unit, state: UserInfoTextFieldState, label: String, placeholder: String) {
    Column(
        modifier = modifier.fillMaxWidth().onFocusChanged { focusState ->
            setUserInfoState(
                label,
                if (state == UserInfoTextFieldState.Error()) {
                    state
                } else {
                    if (focusState.isFocused) {
                        UserInfoTextFieldState.Active()
                    } else {
                        UserInfoTextFieldState.Default()
                    }
                }
            )
        }
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

        if (state == UserInfoTextFieldState.Error()) {
            Text(
                modifier = Modifier.padding(top = 4.dp, start = 20.dp, end = 20.dp),
                text = state.message,
                style = KoreaTypography.caption,
                color = state.color
            )
        }
    }
}

@Composable
private fun TextFieldItem(value: String, onValueChanged: (String) -> Unit, onValueClear: () -> Unit, state: UserInfoTextFieldState, placeholder: String) {
    val focusManager = LocalFocusManager.current

    Box {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChanged,
            textStyle = KoreaTypography.subtitle1.copy(color = Color.White),
            maxLines = 1,
            singleLine = true,
            cursorBrush = SolidColor(DarkColor.Grey400),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }),
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
                    UserInfoTextFieldState.Error() -> ErrorIcon()
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
private fun CloseButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
private fun ErrorIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_error),
        contentDescription = null,
        tint = DarkColor.ErrorRed
    )
}
