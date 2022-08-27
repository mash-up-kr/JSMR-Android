package com.marryting.app.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marryting.app.data.profile.model.Keyword
import com.marryting.app.data.profile.model.ProfileInfo
import com.marryting.app.data.profile.model.QuestionnaireResult
import com.marryting.app.data.profile.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState.Loading)
    val uiState: StateFlow<RegisterState>
        get() = _uiState.asStateFlow()

    private val _profileInfo: MutableStateFlow<ProfileInfo> = MutableStateFlow(ProfileInfo())
    val profileInfo: StateFlow<ProfileInfo>
        get() = _profileInfo.asStateFlow()

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

    fun profileInfoState() = _profileInfo

    fun setProfileInfoName(name: String) {
        viewModelScope.launch {
            _profileInfo.emit(_profileInfo.value.copy(name = name))
        }
    }

    fun setProfileInfoGender(gender: String) {
        viewModelScope.launch {
            _profileInfo.emit(_profileInfo.value.copy(gender = gender))
        }
    }

    fun setProfileInfoBirth(birth: Date) {
        viewModelScope.launch {
            _profileInfo.emit(_profileInfo.value.copy(birth = birth))
        }
    }

    fun setProfileInfoAddress(address: String) {
        viewModelScope.launch {
            _profileInfo.emit(_profileInfo.value.copy(address = address))
        }
    }

    fun setProfileInfoCareer(career: String) {
        viewModelScope.launch {
            _profileInfo.emit(_profileInfo.value.copy(career = career))
        }
    }

    fun addProfileInfoKeyword(keyword: Keyword) {
        if (_profileInfo.value.keywords.size < 5) {
            viewModelScope.launch {
                _profileInfo.emit(_profileInfo.value.copy(keywords = _profileInfo.value.keywords + keyword))
            }
        }
    }

    fun removeProfileInfoKeyword(keyword: Keyword) {
        viewModelScope.launch {
            _profileInfo.emit(
                _profileInfo.value.copy(
                    keywords = _profileInfo.value.keywords.toMutableList().also { it.remove(keyword) }
                )
            )
        }
    }

    private fun getQuestionnaireResultById(questionId: Long): QuestionnaireResult? {
        return _profileInfo.value.answers.find { it.questionId == questionId }
    }

    fun getProfileInfoAnswersById(questionId: Long): String {
        return getQuestionnaireResultById(questionId)?.answer ?: ""
    }

    fun setProfileInfoAnswers(questionId: Long, answer: String) {
        viewModelScope.launch {
            _profileInfo.emit(
                _profileInfo.value.copy(
                    answers = _profileInfo.value.answers.toMutableList().also {
                        val result = getQuestionnaireResultById(questionId)
                        if (result != null) {
                            it.remove(result)
                        }
                        it.add(QuestionnaireResult(questionId, answer))
                    }
                )
            )
        }
    }

    fun onDonePressed() {
        _uiState.value = RegisterState.Result(description = "done")
    }
}
