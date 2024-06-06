package com.kashif.zomatoclonecompose.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.kashif.zomatoclonecompose.ui.utils.Dimens.Padding1

/**
 * Created by Mohammad Kashif Ansari on 29,May,2024
 */
@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = Padding1) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        )
    )
}