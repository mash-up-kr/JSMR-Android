package com.marryting.app.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.marryting.app.component.MarrytingButton
import com.marryting.app.component.MarrytingButtonColorSet
import com.marryting.app.component.MarrytingButtonType
import com.marryting.app.component.MarrytingResultText
import com.ui.theme.Color
import com.ui.theme.DarkColor
import com.ui.theme.KoreaTypography
import com.ui.theme.LightColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterResultScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightBackground),
        containerColor = Color.LightBackground,
        bottomBar = { RegisterResultBottomBar() }
    ) {
        Column {
            // RegisterResultLottie()

            Column(
                modifier = Modifier.padding(start = 32.dp, top = 40.dp)
            ) {
                MarrytingResultText(
                    titleMainColorText = "Nice!\n",
                    titleBackgroundColorText = "Completed",
                    contentName = "박우인",
                    contentResultText = "님을 이렇게 소개할게요.\n" + "메리팅을 찾으러 가볼까요?"
                )

                Row(
                    modifier = Modifier.padding(top = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "행복을 빌어요",
                        color = LightColor.Grey300,
                        style = KoreaTypography.headline4
                    )
                    Image(
                        modifier = Modifier.size(24.dp).padding(start = 2.dp),
                        painter = painterResource(id = R.drawable.ic_clover),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

// @Composable
// private fun RegisterResultLottie(modifier: Modifier = Modifier) {
//    val composition by rememberLottieComposition(
//        LottieCompositionSpec.RawRes(R.raw)
//    )
//    val progress by animateLottieCompositionAsState(composition)
//
//    Box(
//        modifier = modifier.fillMaxWidth()
//    ) {
//        LottieAnimation(
//            modifier = Modifier.align(Alignment.Center),
//            composition = composition,
//            iterations = LottieConstants.IterateForever
//        )
//    }
// }

@Composable
private fun RegisterResultBottomBar() {
    Surface(
        color = androidx.compose.ui.graphics.Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp, start = 82.5.dp, end = 82.5.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            MarrytingButton(
                modifier = Modifier.align(Alignment.Center),
                text = "LET'S GO",
                enabled = true,
                buttonType = MarrytingButtonType.RightArrow(
                    activeColorSet = MarrytingButtonColorSet(
                        contentColor = Color.White,
                        backgroundColor = LightColor.Grey800,
                        arrowColor = Color.Black
                    ),
                    pressedColorSet = MarrytingButtonColorSet(
                        contentColor = Color.White,
                        backgroundColor = LightColor.Main300
                    ),
                    disabledColorSet = MarrytingButtonColorSet(
                        contentColor = DarkColor.Grey200,
                        backgroundColor = DarkColor.Grey300
                    )
                ),
                onClick = { }
            )
        }
    }
}
