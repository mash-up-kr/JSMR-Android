package com.marryting.app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.marryting.app.component.MarrytingButtonType
import com.marryting.app.presentation.profile.component.ProgressIndicator
import com.marryting.app.presentation.profile.component.RegisterContentDescription
import com.marryting.app.presentation.profile.component.RegisterContentTitle
import com.ui.theme.Color
import com.ui.theme.DarkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContentsScreen(
    contents: RegisterState.Contents,
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
        content = {
            //
        },
        bottomBar = {
            RegisterBottomBar(
                contentState = currentContentState,
                onPreviousPressed = { contents.currentContentIndex-- },
                onNextPressed = { contents.currentContentIndex++ },
                onDonePressed = onDonePressed
            )
        }
    )
}

@Composable
private fun RegisterTopBar(
    contentState: RegisterContentState,
    currentContentIndex: Int
) {
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
        Column(modifier = Modifier.padding(top = 16.dp)) {
            RegisterContentTitle(title = contentState.registerContent.title)
            Spacer(modifier = Modifier.padding(4.dp))
            RegisterContentDescription(description = contentState.registerContent.description)
        }
    }
}

@Composable
private fun RegisterBottomBar(
    contentState: RegisterContentState,
    onPreviousPressed: () -> Unit,
    onNextPressed: () -> Unit,
    onDonePressed: () -> Unit
) {
    Surface(
        color = Color.DarkBackground,
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
                    text = "PREV",
                    enabled = true,
                    buttonType = MarrytingButtonType.LeftArrow(
                        DarkColor.Grey700, DarkColor.Grey200
                    ),
                    onClick = onPreviousPressed
                )
            }
            if (contentState.showDone) {
                MarrytingButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "DONE",
                    enabled = contentState.enabledNext,
                    buttonType = MarrytingButtonType.RightArrow(
                        DarkColor.Grey800, DarkColor.SubGreen
                    ),
                    onClick = onDonePressed
                )
            } else {
                MarrytingButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "NEXT",
                    enabled = contentState.enabledNext,
                    buttonType = MarrytingButtonType.RightArrow(
                        DarkColor.Grey800, DarkColor.SubGreen
                    ),
                    onClick = onNextPressed
                )
            }
        }
    }
}
