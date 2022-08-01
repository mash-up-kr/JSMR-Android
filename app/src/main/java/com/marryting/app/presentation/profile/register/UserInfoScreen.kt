package com.marryting.app.presentation.profile.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingTextField
import com.ui.theme.DarkColor

@Preview
@Composable
fun UserInfoScreen(modifier: Modifier = Modifier) {
    Surface(
        color = com.ui.theme.Color.DarkBackground,
        modifier = modifier.padding(top = 40.dp, start = 32.dp, end = 32.dp)
    ) {
        Column(modifier = Modifier) {
            var name by remember { mutableStateOf("") }
            var nameState by remember { mutableStateOf(UserInfoItemState.BASIC) }

            MarrytingTextField(
                modifier = Modifier.onFocusChanged { focusState ->
                    nameState = if (focusState.isFocused) {
                        UserInfoItemState.ACTIVE
                    } else {
                        UserInfoItemState.BASIC
                    }
                },
                value = name,
                onValueChanged = {
                    nameState = if (name.length >= 5) {
                        UserInfoItemState.ERROR
                    } else {
                        UserInfoItemState.ACTIVE
                    }
                    name = it
                },
                onValueClear = { name = "" },
                state = nameState,
                label = "이름",
                placeholder = "ex) 박우인"
            )

            Spacer(modifier = Modifier.height(14.dp))

            var career by remember { mutableStateOf("") }
            var careerState by remember { mutableStateOf(UserInfoItemState.BASIC) }

            MarrytingTextField(
                modifier = Modifier.onFocusChanged { focusState ->
                    careerState = if (focusState.isFocused) {
                        UserInfoItemState.ACTIVE
                    } else {
                        UserInfoItemState.BASIC
                    }
                },
                value = career,
                onValueChanged = {
                    careerState = if (name.length >= 5) {
                        UserInfoItemState.ERROR
                    } else {
                        UserInfoItemState.ACTIVE
                    }
                    career = it
                },
                onValueClear = { career = "" },
                state = careerState,
                label = "직업",
                placeholder = "ex) IT 기획자"
            )
        }
    }
}

enum class UserInfoItemState(val color: Color) {
    ACTIVE(DarkColor.SubGreen),
    ERROR(DarkColor.ErrorRed),
    BASIC(DarkColor.Grey400)
}
