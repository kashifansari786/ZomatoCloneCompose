package com.kashif.zomatoclonecompose.ui.moneyScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.screens.homeScreen.components.TopAppBarComposable

/**
 * Created by Mohammad Kashif Ansari on 06,June,2024
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MoneyScreen(navHostController: NavHostController
) {
    val bgColor = Color(0xFFEEEEEE)
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = bgColor,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {

        }
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Text(text = "Money Layout Coming Soon")
        }
    }
}