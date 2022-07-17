package com.marryting.app.presentation.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.marryting.app.R
import com.ui.theme.LightColor
import com.ui.theme.MontserratFontFamily

@Composable
@Preview
fun EditScreen(viewModel: EditViewModel = hiltViewModel()) {
    Surface {
        Column {
            SmallTopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .width(24.dp)
                            .height(24.dp)
                            .clickable(onClick = {
                            }),
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        contentDescription = ""
                    )
                }
            )
            Column {
                Text(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 32.dp, top = 16.dp),
                    color = LightColor.Grey500,
                    text = "Hello!"
                )
                Row(
                    modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = LightColor.Grey800,
                        text = "김두루미다"
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = LightColor.Grey200,
                        text = "30"
                    )
                    Icon(
                        modifier = Modifier.align(Alignment.Bottom),
                        painter = painterResource(id = R.drawable.ic_profile_edit),
                        contentDescription = ""
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 32.dp, top = 10.dp, end = 32.dp)
                ) {
                    Text(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        text = "서울시 광진구에 살아요"
                    )
                    Text(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        text = "IT회사 기획자로 일해요."
                    )

                    ProfileEditPictures()
                    ProfileEditKeyword(mapOf())
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileEditPictures() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerState = rememberPagerState()

        HorizontalPager(
            modifier = Modifier
                .padding(top = 40.dp),
            count = 5,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 40.dp, vertical = 40.dp)
        ) { page ->
            Text(text = "테스트입니다. $page")
        }

        HorizontalPagerIndicator(
            modifier = Modifier.padding(top = 20.dp),
            pagerState = pagerState
        )
    }
}

@Composable
fun ProfileEditKeyword(keywordList: Map<String, Color>) {
    Column(
        modifier = Modifier
            .padding(top = 60.dp)
    ) {
        ProfileEditTitle(title = "KEYWORD")

        keywordList.forEach { (title, color) ->
            ProfileEditKeywordButton(
                text = title,
                backgroundColor = color
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditKeywordButton(text: String, backgroundColor: Color) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(backgroundColor)
    ) {
        Text(
            fontFamily = MontserratFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            text = text
        )
    }
}

@Composable
@Preview
fun ProfileEditWhoIAm() {
    Column {
        ProfileEditTitle(title = "WHO I AM")

        Text(text = "싸울 땐 생각을 정리하고 이야기")
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = "연락은 1일에 1번 하는 편"
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = "계획적인 데이트가 좋아요"
        )
    }
}

@Composable
fun ProfileEditTitle(title: String) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(LightColor.Grey100)
        )

        Text(
            modifier = Modifier
                .height(40.dp),
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            color = LightColor.Grey700,
            text = title
        )
    }
}
