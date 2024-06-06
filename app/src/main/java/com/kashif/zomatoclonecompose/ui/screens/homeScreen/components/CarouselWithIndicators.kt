package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.CarouselItem
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.carousalList
import com.kashif.zomatoclonecompose.ui.theme.zGreenRatingColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */

@Composable
fun CarouselWithIndicators() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var currentItem by remember { mutableStateOf(0) }

    // Launch a coroutine to handle automatic scrolling
    LaunchedEffect(Unit) {
        var currentItem = 0
        while (true) {
            // Scroll to the next item
            coroutineScope.launch {
                listState.animateScrollToItem(currentItem)
            }
            // Increment the current item or reset to 0 if at the end of the list
            currentItem = (currentItem + 1) % carousalList.size
            // Wait for 3 seconds before scrolling to the next item
            delay(3000L)
        }
    }
    Column {
        LazyRow(
            state = listState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(carousalList.size) { index ->
                CarouselItemView(item = carousalList[index])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}
@Composable
fun CarouselItemView(item: CarouselItem) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(width = 300.dp, height = 200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray)
    ) {
        AsyncImage(
            model = item.image,
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        ) {
            Column {

                Text(text = item.discount,
                    fontSize = Dimens.FontSize4,
                    fontWeight = FontWeight.Bold,
                    color = zWhite
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        text = item.title,
                        fontSize = Dimens.FontSize5, // Use Dimens.FontSize5 if defined
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f) // Take all available space
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Add some space between the texts

                    Box(
                        modifier = Modifier
                            .background(zGreenRatingColor, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item.rating.toString(),
                                fontSize = Dimens.FontSize3, // Use Dimens.FontSize5 if defined
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Icon(
                                painter = painterResource(R.drawable.star), // Replace with your icon resource
                                contentDescription = null, // Optional padding
                                modifier = Modifier.padding(start = 3.dp).size(15.dp),
                                tint = zWhite // Ensure original icon colors are used
                            )
                        }

                    }
                }
            }
        }
        // Icon at the top right corner
        Icon(
            painter = painterResource(R.drawable.heart_gray_empty), // Replace with your icon resource
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp), // Optional padding
            tint = Color.Unspecified // Ensure original icon colors are used
        )
        Icon(
            painter = painterResource(R.drawable.extra_badge), // Replace with your icon resource
            contentDescription = null,
            modifier = Modifier.size(40.dp)
                .align(Alignment.TopStart)
                .padding(10.dp), // Optional padding
            tint = Color.Unspecified // Ensure original icon colors are used
        )

    }
}