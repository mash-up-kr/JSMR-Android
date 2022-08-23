package com.marryting.app.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = hiltViewModel()) {
    val profileInfoState by viewModel.profileInfoState().collectAsState()

    when (val state = viewModel.uiState.collectAsState().value) {
        is RegisterState.Contents -> RegisterContentsScreen(
            contents = state,
            getProfileInfoName = profileInfoState.name,
            setProfileInfoName = viewModel::setProfileInfoName,
            getProfileInfoGender = profileInfoState.gender,
            setProfileInfoGender = viewModel::setProfileInfoGender,
            getProfileInfoBirth = profileInfoState.birth,
            setProfileInfoBirth = viewModel::setProfileInfoBirth,
            getProfileInfoAddress = profileInfoState.address,
            setProfileInfoAddress = viewModel::setProfileInfoAddress,
            getProfileInfoCareer = profileInfoState.career,
            setProfileInfoCareer = viewModel::setProfileInfoCareer,
            getProfileInfoKeywords = profileInfoState.keywords,
            addProfileInfoKeywords = viewModel::addProfileInfoKeyword,
            removeProfileInfoKeyword = viewModel::removeProfileInfoKeyword,
            getProfileInfoAnswers = profileInfoState.answers,
            setProfileInfoAnswers = viewModel::setProfileInfoAnswers,
            onDonePressed = viewModel::onDonePressed
        )
        is RegisterState.Result -> RegisterResultScreen()
    }
}
