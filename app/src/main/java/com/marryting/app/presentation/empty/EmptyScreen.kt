package com.marryting.app.presentation.empty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.marryting.app.component.MarrytingButton
import com.marryting.app.component.MarrytingButtonType
import com.ui.theme.Color
import com.ui.theme.LightColor

@Composable
fun EmptyScreen() {

    Surface {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 96.dp, start = 32.dp, end = 32.dp),
                alignment = Alignment.TopCenter,
                painter = painterResource(id = R.drawable.ic_empty_view),
                contentDescription = ""
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Image(
                    modifier = Modifier.align(Alignment.End),
                    painter = painterResource(id = R.drawable.ic_empty_friend),
                    contentDescription = ""
                )

                MarrytingButton(
                    modifier = Modifier
                        .width(176.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 40.dp, top = 10.dp),
                    buttonType = MarrytingButtonType.RightArrow(
                        textAndCircleColor = Color.White,
                        backgroundAndArrowColor = LightColor.Grey800,
                    ),
                    text = "SHARE",
                    enabled = true
                ) {
                }
            }
        }
    }
}
