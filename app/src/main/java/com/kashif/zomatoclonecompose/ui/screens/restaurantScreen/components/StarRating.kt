package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R

/**
 * Created by Mohammad Kashif Ansari on 06,June,2024
 */
@Composable
fun StarRating(
    rating: Float,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    onRatingChanged: (Float) -> Unit
) {
    Row(modifier = modifier) {
        for (i in 1..maxRating) {
            val fillRatio = when {
                rating >= i -> 1f
                rating > i - 1 -> rating - (i - 1)
                else -> 0f
            }

            Box(
                modifier = Modifier
                    .size(15.dp)
                    .padding(2.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star_border),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(12.dp)
                )
                if (fillRatio > 0f) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxWidth(fillRatio).size(12.dp)
                    )
                }
            }
        }
    }
}