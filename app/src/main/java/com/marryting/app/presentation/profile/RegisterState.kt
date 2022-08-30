package com.marryting.app.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.marryting.app.data.profile.model.RegisterContent
import com.ui.theme.DarkColor

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

data class UserInfoState(
    val nameState: UserInfoTextFieldState = UserInfoTextFieldState.Default(),
    val careerState: UserInfoTextFieldState = UserInfoTextFieldState.Default(),
    val addressState: UserInfoTextFieldState = UserInfoTextFieldState.Default()
)

sealed class UserInfoTextFieldState(
    open val color: Color,
    open val message: String = ""
) {
    data class Default(
        override val color: Color = DarkColor.Grey400
    ) : UserInfoTextFieldState(color)

    data class Active(
        override val color: Color = DarkColor.SubGreen
    ) : UserInfoTextFieldState(color)

    data class Error(
        override val color: Color = DarkColor.ErrorRed,
        override val message: String = ""
    ) : UserInfoTextFieldState(color, message)
}
