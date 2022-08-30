package com.marryting.app.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.marryting.app.R
import com.marryting.app.presentation.profile.UserInfoTextFieldState
import com.ui.theme.Color
import com.ui.theme.DarkColor

@Composable
fun MarrytingDropdown(modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, state: UserInfoTextFieldState, label: String, placeholder: String) {
    var isDropdownMenuExpanded by remember { mutableStateOf(false) }

    Container(
        modifier = modifier
            .noRippleClickable(
                interactionSource = MutableInteractionSource(),
                enabled = true,
                onClick = { isDropdownMenuExpanded = true }
            ),
        state = state,
        label = label
    ) {
        DropdownItem(
            value = value,
            placeholder = placeholder
        ) {
            GenderDropdownMenu(
                isDropdownMenuExpanded = isDropdownMenuExpanded,
                onDismissRequest = { isDropdownMenuExpanded = false },
                onValueChanged = onValueChanged
            )
        }
    }
}

@Composable
fun DropdownItem(value: String, placeholder: String, item: @Composable () -> Unit) {
    Box {
        if (value.isEmpty()) {
            PlaceHolder(placeholder = placeholder, color = DarkColor.Grey400)
        } else {
            PlaceHolder(placeholder = value, color = Color.White)
        }

        Box(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            DropdownIcon()
            item()
        }
    }
}

@Composable
private fun DropdownIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_dropdown),
        contentDescription = null,
        tint = DarkColor.Grey400
    )
}

@Composable
private fun GenderDropdownMenu(modifier: Modifier = Modifier, isDropdownMenuExpanded: Boolean, onDismissRequest: () -> Unit, onValueChanged: (String) -> Unit) {
    DropdownMenu(
        modifier = modifier.wrapContentSize(),
        expanded = isDropdownMenuExpanded,
        onDismissRequest = { onDismissRequest() }
    ) {
        val items = listOf("남성", "여성")

        items.forEach { value ->
            GenderDropdownMenuItem(
                value = value,
                onDismissRequest = { onDismissRequest() },
                onValueChanged = onValueChanged
            )
        }
    }
}

@Composable
private fun GenderDropdownMenuItem(value: String, onDismissRequest: () -> Unit, onValueChanged: (String) -> Unit) {
    DropdownMenuItem(
        onClick = {
            onValueChanged(value)
            onDismissRequest()
        }
    ) {
        Text(text = value)
    }
}
