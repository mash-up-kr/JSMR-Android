package com.marryting.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marryting.app.data.profile.RegisterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// @HiltViewModel
class RegisterViewModel(
    private val registerRepository: RegisterRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState.Loading)
    val uiState: StateFlow<RegisterState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val registerContents = registerRepository.getRegisterContents()

//            val contentViewType = registerContents[0].contentViewType
//            if (contentViewType is ContentViewType.Keywords){
//            }

            val contents: List<RegisterContentState> = registerContents.mapIndexed { idx, content ->
                val showPrevious = idx > 0
                val showDone = idx == registerContents.size - 1
                RegisterContentState(
                    registerContent = content,
                    totalContentsCount = registerContents.size,
                    showPrevious = showPrevious,
                    showDone = showDone
                )
            }
            _uiState.value = RegisterState.Contents(contents)
        }
    }

    fun onDonePressed() {
        _uiState.value = RegisterState.Result(description = "done")
    }
}
