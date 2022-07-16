package com.marryting.app.presentation.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marryting.app.R
import com.ui.theme.LightColor

@Composable
fun EditScreen() {
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
                        contentDescription = "",
                    )
                }
            }
        }
    }
}
