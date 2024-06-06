package com.kashif.zomatoclonecompose.screens.loginScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.kashif.zomatoclonecompose.screens.loginScreen.components.LoginForm
import com.kashif.zomatoclonecompose.screens.loginScreen.components.LoginScreenBottomInfoBar

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navHostController: NavHostController) {
    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize().navigationBarsPadding(),
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
        ) {
            LoginForm(navHostController=navHostController)
            LoginScreenBottomInfoBar()
        }
    }
}
