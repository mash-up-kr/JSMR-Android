package com.marryting.app.presentation.wedding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marryting.app.R
import com.ui.theme.EnglishTypography
import com.ui.theme.KoreaTypography
import com.ui.theme.LightColor

@Composable
@Preview
fun ParticipationScreen() {
    Surface {
        Column {
            Image(
                modifier = Modifier
                    .padding(top = 60.dp, start = 32.dp),
                painter = painterResource(
                    id = R.drawable.ic_wedding
                ),
                contentDescription = ""
            )

            LazyColumn(content = {
            })
        }
    }
}

@Composable
@Preview
fun ParticipationItem() {
    Column(
        modifier = Modifier
            .padding(start = 32.dp)
    ) {
        Text(
            style = KoreaTypography.headline2,
            modifier = Modifier,
            color = LightColor.Grey100,
            text = "01"
        )

        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                style = KoreaTypography.headline2,
                color = LightColor.Grey800,
                text = "김신랑"
            )
            Image(
                modifier = Modifier.padding(
                    horizontal = 2.dp
                ),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = ""
            )
            Text(
                style = KoreaTypography.headline2,
                color = LightColor.Grey800,
                text = "박신부"
            )
        }
        Text(
            style = EnglishTypography.subtitle1,
            modifier = Modifier.padding(top = 5.dp),
            color = LightColor.Grey400,
            text = "2022. 01. 20"
        )

        Row {
            Spacer(
                Modifier.weight(1f)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 20.dp, end = 32.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(LightColor.Grey800)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = ""
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxWidth()
                .background(LightColor.Grey100)
                .height(2.dp)
        )
    }
}
