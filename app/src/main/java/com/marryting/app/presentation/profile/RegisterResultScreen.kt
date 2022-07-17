package com.marryting.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ui.theme.DarkColor

@Composable
fun RegisterResultScreen() {
    Surface(modifier = Modifier.background(DarkColor.SubGreen)) {
        Text(text = "done")
    }
}
