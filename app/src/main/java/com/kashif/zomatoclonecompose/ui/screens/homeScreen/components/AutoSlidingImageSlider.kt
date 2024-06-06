package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.RestaurantImage
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.restaurantList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zDarkGray
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import kotlinx.coroutines.delay

import androidx.compose.foundation.layout.*
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import com.kashif.zomatoclonecompose.ui.utils.Dimens.FontSize2

/**
 * Created by Mohammad Kashif Ansari on 02,June,2024
 */
@OptIn( ExperimentalAnimationApi::class)
@Composable
fun AutoSlidingImageSlider(images: List<RestaurantImage>, dp: Dp) {
    val pageCount = images.size
    val pagerState = rememberPagerState(initialPage = 0)

    val indicatorSize = 8.dp
    val expandedIndicatorSize = 16.dp
    val progressBarHeight = 4.dp

    var currentPage by remember { mutableStateOf(0) }

    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000L)
            currentPage = (pagerState.currentPage + 1) % pageCount
            pagerState.animateScrollToPage(currentPage)
        }
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(dp)) {
        HorizontalPager(
            state = pagerState,
            count = pageCount,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            AnimatedContent(
                targetState = images[page].image,
                transitionSpec = {
                    if (pagerState.currentPage == page) {
                        slideInHorizontally(
                            initialOffsetX = { +it },
                            animationSpec = tween(500)
                        ) with slideOutHorizontally(
                            targetOffsetX = { -it },
                            animationSpec = tween(300)
                        )
                    } else {
                        EnterTransition.None with ExitTransition.None
                    }
                }
            ) { imageRes ->
                AsyncImage(
                    model = imageRes,
                    contentDescription = images[page].title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            if (!images[page].title.isNullOrEmpty()) {
                Box(modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 10.dp, top = 15.dp)
                    .background(Color.DarkGray)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = images[page].title,
                        fontSize = FontSize2,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 46.dp, start = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { index ->
                val isSelected = pagerState.currentPage == index

                val size by animateDpAsState(
                    targetValue = if (isSelected) expandedIndicatorSize else indicatorSize,
                    animationSpec = tween(durationMillis = 300)
                )

                val progress by animateFloatAsState(
                    targetValue = if (isSelected) 1f else 0f,
                    animationSpec = tween(durationMillis = 3000, easing = LinearEasing)
                )

                if (!isSelected) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(size)
                            .clip(CircleShape)
                            .background(
                                color = if (isSelected) Color.Gray else Color.LightGray,
                                shape = CircleShape
                            )
                    )
                }

                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(expandedIndicatorSize)
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawRoundRect(
                                color = Color.White,
                                topLeft = Offset.Zero,
                                size = Size(size.toPx() * progress, progressBarHeight.toPx()),
                                cornerRadius = CornerRadius(progressBarHeight.toPx())
                            )
                        }
                    }
                }
            }
        }
    }
}






@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {
    val navHostController: NavHostController = rememberNavController()
    val scrollState = rememberScrollState()
    //HomeScreen(navHostController,scrollState,false)
    val images = listOf(
        RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/3/20732153/b6ddde51d1b8ffa3b619b6e8e08b7ce0_o2_featured_v2.jpg?fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
        RestaurantImage(
            image = "https://b.zmtcdn.com/data/dish_photos/937/6bd5c728351781126a159b3988a4a937.jpg?output-format=webp",
            title = "Chicken Tikka Biryani . ₹240"
        ),
        RestaurantImage(
            image = "https://b.zmtcdn.com/data/dish_photos/b68/a9931ed5fdbddee442e519cc0a0ebb68.png?output-format=webp",
            title = "Hara Bhara Kebab . ₹220"
        ),
        RestaurantImage(
            image = "https://b.zmtcdn.com/data/dish_photos/685/442de9c16d4421d2c5ff9f47553fa685.jpg?output-format=webp",
            title = "Lemon Garlic Chicken . ₹299"
        ),
        RestaurantImage(
            image = "https://b.zmtcdn.com/data/dish_photos/a7e/c7a304a63550332141ad90557b031a7e.jpg?output-format=webp",
            title = "Paneer Tikka . ₹260"
        )
    )
    val height= images.size*300
    //AutoSlidingImageSlider(images,height.dp)
    PreviewCustomSteppedLayout()
    // HomeScreen(navHostController, isCollapsed)
}

@Composable
fun CustomSteppedLayout() {
    Box(
        modifier = Modifier
            .size(150.dp, 25.dp)
            .background(Color.Transparent)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val straightLineLength = 110.dp.toPx()
            val cornerRadius = 5.dp.toPx()

            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(straightLineLength, 0f)
                arcTo(
                    rect = Rect(
                        straightLineLength, 0f,
                        straightLineLength + 4 * cornerRadius, 1 * cornerRadius
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                lineTo(width, height)
                lineTo(0f, height)
                close()
            }

            drawPath(path = path, color = zWhite, style = Fill)
        }
    }
}


@Composable
fun PreviewCustomSteppedLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSteppedLayout()
    }
}