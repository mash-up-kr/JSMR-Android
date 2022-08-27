package com.marryting.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marryting.app.component.MarrytingButton
import com.marryting.app.component.MarrytingButtonColorSet
import com.marryting.app.component.MarrytingButtonType
import com.marryting.app.data.profile.model.ContentViewType
import com.marryting.app.data.profile.model.Keyword
import com.marryting.app.data.profile.model.Questionnaire
import com.marryting.app.data.profile.model.QuestionnaireResult
import com.marryting.app.presentation.picture.PictureScreen
import com.marryting.app.presentation.profile.component.ProgressIndicator
import com.marryting.app.presentation.profile.component.RegisterContentDescription
import com.marryting.app.presentation.profile.component.RegisterContentTitle
import com.marryting.app.presentation.profile.register.KeywordScreen
import com.marryting.app.presentation.profile.register.QuestionnaireScreen
import com.marryting.app.presentation.profile.register.UserInfoScreen
import com.ui.theme.Color
import com.ui.theme.DarkColor
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContentsScreen(
    contents: RegisterState.Contents,
    getProfileInfoName: String?,
    setProfileInfoName: (String) -> Unit,
    getProfileInfoGender: String?,
    setProfileInfoGender: (String) -> Unit,
    getProfileInfoBirth: Date?,
    setProfileInfoBirth: (Date) -> Unit,
    getProfileInfoAddress: String?,
    setProfileInfoAddress: (String) -> Unit,
    getProfileInfoCareer: String?,
    setProfileInfoCareer: (String) -> Unit,
    getProfileInfoKeywords: List<Keyword>?,
    addProfileInfoKeywords: (Keyword) -> Unit,
    removeProfileInfoKeyword: (Keyword) -> Unit,
    getProfileInfoAnswersById: (Long) -> String,
    setProfileInfoAnswers: (Long, String) -> Unit,
    onDonePressed: () -> Unit
) {
    val currentContentState = remember(contents.currentContentIndex) {
        contents.registerContentsState[contents.currentContentIndex]
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkBackground),
        containerColor = Color.DarkBackground,
        topBar = {
            RegisterTopBar(
                contentState = currentContentState,
                currentContentIndex = contents.currentContentIndex
            )
        },
        bottomBar = {
            RegisterBottomBar(
                contentState = currentContentState,
                onPreviousPressed = { contents.currentContentIndex-- },
                onNextPressed = { contents.currentContentIndex++ },
                onDonePressed = onDonePressed
            )
        }
    ) { paddingValues ->
        when (currentContentState.registerContent.contentViewType) {
            ContentViewType.UserInfo -> {
                UserInfoScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    getProfileInfoName = getProfileInfoName,
                    setProfileInfoName = setProfileInfoName,
                    getProfileInfoGender = getProfileInfoGender,
                    setProfileInfoGender = setProfileInfoGender,
                    getProfileInfoBirth = getProfileInfoBirth,
                    setProfileInfoBirth = setProfileInfoBirth,
                    getProfileInfoAddress = getProfileInfoAddress,
                    setProfileInfoAddress = setProfileInfoAddress,
                    getProfileInfoCareer = getProfileInfoCareer,
                    setProfileInfoCareer = setProfileInfoCareer
                )
            }
            ContentViewType.Picture -> {
                PictureScreen(modifier = Modifier.padding(top = paddingValues.calculateTopPadding()))
            }
            ContentViewType.Keyword -> {
                KeywordScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    keywordList = listOf(
                        Keyword(1, "따듯한"), Keyword(2, "유머있는"), Keyword(3, "다정한"),
                        Keyword(4, "편안한"), Keyword(5, "친절한"), Keyword(6, "몰라")
                    ),
                    getProfileInfoKeywords = getProfileInfoKeywords,
                    addProfileInfoKeywords = addProfileInfoKeywords,
                    removeProfileInfoKeyword = removeProfileInfoKeyword
                )
            }
            ContentViewType.Questionnaire -> {
                QuestionnaireScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    questionnaireList = listOf(
                        Questionnaire(
                            questionId = 1,
                            question = "싸울 때는",
                            answer1 = "생각 정리하고 이야기 할래요",
                            answer2 = "바로 이야기 할래요"
                        ),
                        Questionnaire(
                            questionId = 2,
                            question = "연락은",
                            answer1 = "가끔 하고 싶어요",
                            answer2 = "자주 하고 싶어요"
                        ),
                        Questionnaire(
                            questionId = 3,
                            question = "데이트는",
                            answer1 = "계획적인 게 좋아요",
                            answer2 = "즉흥적인 게 좋아요"
                        )
                    ),
                    getProfileInfoAnswersById = getProfileInfoAnswersById,
                    setProfileInfoAnswers = setProfileInfoAnswers
                )
            }
        }
    }
}

@Composable
private fun RegisterTopBar(contentState: RegisterContentState, currentContentIndex: Int) {
    Surface(
        color = Color.DarkBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 84.dp, start = 32.dp, end = 32.dp)
    ) {
        ProgressIndicator(
            currentContentIndex = currentContentIndex,
            totalContentsCount = contentState.totalContentsCount
        )
        Column(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            RegisterContentTitle(title = contentState.registerContent.title)
            RegisterContentDescription(description = contentState.registerContent.description)
        }
    }
}

@Composable
private fun RegisterBottomBar(contentState: RegisterContentState, onPreviousPressed: () -> Unit, onNextPressed: () -> Unit, onDonePressed: () -> Unit) {
    Surface(
        color = androidx.compose.ui.graphics.Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp, start = 32.dp, end = 32.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (contentState.showPrevious) {
                MarrytingButton(
                    modifier = Modifier.padding(end = 22.dp),
                    text = "PRE",
                    enabled = true,
                    buttonType = MarrytingButtonType.LeftArrow(
                        activeColorSet = MarrytingButtonColorSet(
                            contentColor = DarkColor.Grey200,
                            backgroundColor = DarkColor.Grey700,
                            arrowColor = DarkColor.Grey200
                        ),
                        pressedColorSet = MarrytingButtonColorSet(
                            contentColor = Color.White,
                            backgroundColor = DarkColor.Grey600,
                            arrowColor = Color.White
                        )
                    ),
                    onClick = onPreviousPressed
                )
            }
            if (contentState.showDone) {
                NextAndDoneButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "DONE",
                    enabled = contentState.enabledNext,
                    onClick = onDonePressed
                )
            } else {
                NextAndDoneButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "NEXT",
                    enabled = contentState.enabledNext,
                    onClick = onNextPressed
                )
            }
        }
    }
}

@Composable
private fun NextAndDoneButton(modifier: Modifier = Modifier, text: String, enabled: Boolean, onClick: () -> Unit) {
    MarrytingButton(
        modifier = modifier,
        text = text,
        enabled = enabled,
        buttonType = MarrytingButtonType.RightArrow(
            activeColorSet = MarrytingButtonColorSet(
                contentColor = DarkColor.Grey800,
                backgroundColor = DarkColor.SubGreen,
                arrowColor = Color.White
            ),
            pressedColorSet = MarrytingButtonColorSet(
                contentColor = Color.White,
                backgroundColor = DarkColor.SubGreen
            ),
            disabledColorSet = MarrytingButtonColorSet(
                contentColor = DarkColor.Grey200,
                backgroundColor = DarkColor.Grey300
            )
        ),
        onClick = onClick
    )
}
