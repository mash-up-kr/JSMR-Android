package com.marryting.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marryting.app.presentation.LoginScreen
import com.marryting.app.presentation.empty.EmptyScreen
import com.marryting.app.presentation.profile.RegisterScreen
import com.marryting.app.presentation.login.LoginScreen
import com.marryting.app.presentation.profile.RegisterScreen
import com.ui.theme.MarrytingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MarrytingTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen()
        }
        composable("empty") {
            EmptyScreen()
        }
        composable("register") {
            RegisterScreen()
        }
    }
}
