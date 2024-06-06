package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R

/**
 * Created by Mohammad Kashif Ansari on 30,May,2024
 */
@Composable
fun ExpandedTopBar(screenHeight: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight)

    ) {

        Image(
            painter = painterResource(R.drawable.zomato_home_coupon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
            contentScale = ContentScale.Crop
        )

    }
}