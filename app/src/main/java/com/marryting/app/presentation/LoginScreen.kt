package com.marryting.app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marryting.app.R

@Composable
fun LoginScreen() {

    Scaffold {
        Box(modifier = Modifier.padding(it)) {

            Column {
                Image(
                    modifier = Modifier
                        .padding(top = 146.dp)
                        .fillMaxWidth(),
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "카카오톡으로 시작하기")
                }
            }
        }
    }
}
