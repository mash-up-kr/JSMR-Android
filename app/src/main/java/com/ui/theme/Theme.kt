package com.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MarrytingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    ThemeState.darkModeState.value = darkTheme
    MaterialTheme(
        typography = Typography,
        content = content
    )
}
