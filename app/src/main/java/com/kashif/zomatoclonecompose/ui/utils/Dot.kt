package com.kashif.zomatoclonecompose.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.ui.theme.zDarkGray

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */

@Composable
fun Dot() {
    Box(
        modifier = Modifier
            .size(4.dp)
            .background(color = zDarkGray, shape = CircleShape)
    )
}