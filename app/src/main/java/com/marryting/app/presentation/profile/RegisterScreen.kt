package com.marryting.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ui.theme.Color

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = viewModel()) { // hiltViewModel()로 변경해야 함

    when (val state = viewModel.uiState.collectAsState().value) {
        is RegisterState.Contents -> RegisterContentsScreen(
            contents = state,
            onDonePressed = { viewModel.onDonePressed() }
        )
        is RegisterState.Result -> RegisterResultScreen()
    }
}
