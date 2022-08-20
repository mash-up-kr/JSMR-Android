package com.marryting.app.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.marryting.app.data.profile.model.RegisterContent

data class RegisterContentState(
    val registerContent: RegisterContent,
    val totalContentsCount: Int,
    val showPrevious: Boolean,
    val showDone: Boolean
) {
    var enabledNext: Boolean by mutableStateOf(true) // false로 해야 함
}

sealed class RegisterState {
    object Loading : RegisterState()

    data class Contents(
        val registerContentsState: List<RegisterContentState>
    ) : RegisterState() {
        var currentContentIndex: Int by mutableStateOf(0)
    }

    data class Result(
        val description: String? = ""
    ) : RegisterState()
}
