package com.marryting.app.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marryting.app.R
import com.marryting.app.component.noRippleClickable
import com.ui.theme.Color
import com.ui.theme.KoreaTypography
import com.ui.theme.LightColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val annotatedString = getAnnotatedString()

    Scaffold(
        modifier = Modifier.background(Color.LightBackground),
        containerColor = Color.LightBackground
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 157.dp, bottom = 53.dp)
                    .height(270.dp)
                    .width(317.dp),
                painter = painterResource(id = R.drawable.ic_login_logo),
                contentDescription = null
            )

            Button(onClick = {
                navController.navigate("register")
            }) {
                Text(text = "profile 화면이동")
            }

            Button(onClick = {
                navController.navigate("empty")
            }) {
                Text(text = "empty 화면이동")
            }

            Image(
                modifier = Modifier
                    .noRippleClickable(
                        interactionSource = MutableInteractionSource(),
                        enabled = true,
                        onClick = {
                            navController.navigate("edit")
//                            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
//                                UserApiClient.instance.loginWithKakaoTalk(
//                                    context = context,
//                                    callback = { token, error ->
//                                    }
//                                )
//                            } else {
//                                UserApiClient.instance.loginWithKakaoAccount(
//                                    context = context,
//                                    callback = { token, error ->
//                                    }
//                                )
//                            }
                        }
                    ),
                painter = painterResource(id = R.drawable.ic_kakao_login),
                contentDescription = null
            )

            ClickableText(
                modifier = Modifier.padding(top = 8.dp),
                text = annotatedString,
                style = KoreaTypography.caption,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(tag = "policy", start = offset, end = offset)
                        .firstOrNull()?.let { stringAnnotation ->
                            uriHandler.openUri(stringAnnotation.item)
                        }
                }
            )
        }
    }
}

private fun getAnnotatedString() = buildAnnotatedString {
    pushStringAnnotation(
        tag = "policy",
        annotation = "https://sneaky-cardinal-8ae.notion.site/Marry-ting-4315776a50d5415eb7b60cb9c083acbf"
    )
    withStyle(
        style = SpanStyle(
            color = LightColor.Grey300
        )
    ) {
        append("개인정보처리방침")
    }
    pop()
}
