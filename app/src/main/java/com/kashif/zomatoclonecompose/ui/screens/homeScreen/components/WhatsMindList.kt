package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.mindList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */

@Composable
fun WhatsMindList() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), // Adjust height as needed
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        items(mindList){ item->
            Column(modifier = Modifier.background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.image)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.placeholder_image),
                    error = painterResource(R.drawable.placeholder_image),
                    contentDescription = item.name,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(zWhite) // Optional: Set a background color to visualize the clipping
                )
                Text(text = item.name,
                    fontSize = Dimens.FontSize2,
                    fontWeight = FontWeight.Normal,
                    color = zBlack
                )
            }
        }
    }

}
