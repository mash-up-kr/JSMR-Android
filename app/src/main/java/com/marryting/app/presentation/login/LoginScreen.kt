package com.marryting.app.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kakao.sdk.user.UserApiClient
import com.marryting.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 146.dp)
                    .align(Alignment.TopCenter),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )

            Row {
                Button(onClick = {
                    navController.navigate("register")
                }) {
                    Text(text = "profile 화면이동")
                }
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 78.dp)
                    .align(Alignment.BottomCenter)
                    .clickable(
                        onClick = {
                            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                                UserApiClient.instance.loginWithKakaoTalk(
                                    context = context,
                                    callback = { token, error ->
                                    }
                                )
                            } else {
                                UserApiClient.instance.loginWithKakaoAccount(
                                    context = context,
                                    callback = { token, error ->
                                    }
                                )
                            }
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_kakao_login),
                    contentDescription = ""
                )
            }
        }
    }
}
