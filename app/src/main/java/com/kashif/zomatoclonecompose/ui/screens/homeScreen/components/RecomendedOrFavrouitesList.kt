package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.restaurants
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 31,May,2024
 */
@Composable
fun RecomendedOrFavrouitesList(navHostController: NavHostController, i: Int) {

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp), // Adjust height as needed
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(restaurants) { item->
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp).clickable {
                    navHostController.navigate(Route.RestaurantScreen.route)
                },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start) {
                Box() {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item.url)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.placeholder_image),
                        error= painterResource(R.drawable.placeholder_image),
                        contentDescription = item.title,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(width = 120.dp, height = 80.dp)
                            .clip(
                                RoundedCornerShape(Dimens.Padding1)
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(4.dp)
                    ) {
                        Column {
                            Text(text = item.discount,
                                fontSize = Dimens.FontSize2,
                                fontWeight = FontWeight.Bold,
                                color = zWhite
                            )
                            Text(text = item.discount2,
                                fontSize = Dimens.FontSize1,
                                fontWeight = FontWeight.Normal,
                                color = zWhite
                            )
                        }
                    }
                    // Icon at the top right corner
                    Icon(
                        painter = painterResource(R.drawable.heart_gray_empty), // Replace with your icon resource
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                            .align(Alignment.TopEnd)
                            .padding(4.dp), // Optional padding
                        tint = Color.Unspecified // Ensure original icon colors are used
                    )

                }
                Text(text = item.title,
                    fontSize = Dimens.FontSize2,
                    fontWeight = FontWeight.Bold,
                    color = zBlack
                )
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Icon(painter = painterResource(id = R.drawable.fortyfive_min),
                        contentDescription = "time",
                        modifier = Modifier.size(10.dp),
                        tint = Color.Unspecified)
                    Text(text = item.timeOfClose,
                        fontSize = Dimens.FontSize1,
                        fontWeight = FontWeight.Normal,
                        color = zLightGray,
                        modifier = Modifier.padding(start = 5.dp))
                }

            }
        }
    }
}
@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {
   // RecomendedOrFavrouitesList(0, it)
    //WhatsMindList()
    // HomeScreen(navHostController, isCollapsed)
}
