package com.kashif.zomatoclonecompose.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Mohammad Kashif Ansari on 29,May,2024
 */
@Composable
fun GetScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    // Calculate status bar height
    val statusBarHeight = with(LocalDensity.current) { 24.dp } // Default status bar height
    // Adjust the value based on device or configuration if needed

    // Calculate navigation bar height
    val navigationBarHeight = with(LocalDensity.current) { 48.dp } // Default navigation bar height
    // Adjust the value based on device or configuration if needed

    // Calculate usable screen height
    val usableScreenHeight = screenHeight - statusBarHeight - navigationBarHeight

    return usableScreenHeight*0.6f
}