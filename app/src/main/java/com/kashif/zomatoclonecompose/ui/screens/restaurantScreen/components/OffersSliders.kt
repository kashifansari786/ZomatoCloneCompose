package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.offers
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zDarkBlueGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkGoldenDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkGoldenGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkGray
import com.kashif.zomatoclonecompose.ui.theme.zLightBlueDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightBlueGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightGoldenDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightGoldenGradient
import com.kashif.zomatoclonecompose.ui.theme.zSliderDark
import com.kashif.zomatoclonecompose.ui.theme.zSliderLight
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import com.yugesh.zomatoclone.screens.restaurantScreen.RestaurantScreen
import kotlinx.coroutines.delay

/**
 * Created by Mohammad Kashif Ansari on 04,June,2024
 */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OfferSliders(){

    val pageCount = offers.size
    val pagerState = rememberPagerState(initialPage = 0)

    val indicatorSize = 8.dp
   

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
            .padding(start = 10.dp, end = 10.dp)
            .height(100.dp)){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 15.dp, bottom = 10.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        shape = RoundedCornerShape(Dimens.MediumPadding24),
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                offers[currentPage].gradientDark,
                                offers[currentPage].gradientLight
                            )
                        )
                    )
            ) {

            }
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier  = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 35.dp)) {
                HorizontalPager(
                    state = pagerState,
                    count = pageCount,

                ) {page->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                        )
                    {
                        AnimatedContent(
                            targetState = offers[page].title,
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
                        ) {
                            Text(
                                text = it,
                                fontSize = Dimens.FontSize4,
                                fontWeight = FontWeight.Bold,
                                color = zBlack,
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        AnimatedContent(
                            targetState = offers[page].desc,
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
                        ) {
                            Text(
                                text = it,
                                fontSize = Dimens.FontSize3,
                                fontWeight = FontWeight.Normal,
                                color = zDarkGray,
                            )
                        }


                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pageCount) { index ->
                        val isSelected = pagerState.currentPage == index

                        val size by animateDpAsState(
                            targetValue =  indicatorSize,
                            animationSpec = tween(durationMillis = 300)
                        )


                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(size)
                                .clip(CircleShape)
                                .background(
                                    color = if (isSelected) zSliderDark else zSliderLight,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
                .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                PointedGradientDivider(modifier=Modifier.height(1.5.dp).weight(1f),
                    startColor =  offers[currentPage].dividerLight,
                    endColor = offers[currentPage].dividerDark,
                    strokeWidth = 8f
                )

//                Divider(modifier = Modifier
//                    .height(1.5.dp)
//                    .weight(1f)
//                    .background(
//                        brush = Brush.horizontalGradient(
//                            colors = listOf(
//                                offers[currentPage].dividerLight,
//                                offers[currentPage].dividerDark
//                            )
//                        )
//                    ))
                Spacer(modifier = Modifier.width(2.dp))
                Icon(painter = painterResource(id = offers[currentPage].icon),
                    contentDescription = "percentage",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                ReversedPointedGradientDivider(modifier=Modifier.height(1.5.dp).weight(1f),
                    startColor =  offers[currentPage].dividerDark,
                    endColor = offers[currentPage].dividerLight,
                    strokeWidth = 8f
                )

            }
        }


}
@Composable
fun ReversedPointedGradientDivider(
    modifier: Modifier = Modifier,
    startColor: Color = Color.Black,
    endColor: Color = Color.Transparent,
    strokeWidth: Float = 4f
) {
    Canvas(modifier = modifier.fillMaxWidth().height(strokeWidth.dp)) {
        val width = size.width
        val height = size.height

        // Define the path for the divider with a pointed start
        val path = Path().apply {
            moveTo(0f, height / 2)
            lineTo(height / 2, 0f)
            lineTo(width, height / 2)
            lineTo(height / 2, height)
            close()
        }

        // Define the gradient brush
        val gradient = Brush.linearGradient(
            colors = listOf(startColor, endColor),
            start = Offset(0f, height / 2),
            end = Offset(width, height / 2)
        )

        // Draw the path with the gradient brush
        drawPath(
            path = path,
            brush = gradient
        )
    }
}
@Composable
fun PointedGradientDivider(
    modifier: Modifier = Modifier,
    startColor: Color = Color.Black,
    endColor: Color = Color.Transparent,
    strokeWidth: Float = 4f
) {
    Canvas(modifier = modifier.fillMaxWidth().height(strokeWidth.dp)) {
        val width = size.width
        val height = size.height

        // Define the path for the divider with a pointed end
        val path = Path().apply {
            moveTo(0f, height / 2)
            lineTo(width - height / 2, height / 2)
            lineTo(width, 0f)
            lineTo(width, height)
            close()
        }

        // Define the gradient brush
        val gradient = Brush.linearGradient(
            colors = listOf(startColor, endColor),
            start = Offset(0f, height / 2),
            end = Offset(width, height / 2)
        )

        // Draw the path with the gradient brush
        drawPath(
            path = path,
            brush = gradient
        )
    }
}
@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {

    OfferSliders()
    //AllRestaurantsList()
    // HomeScreen(navHostController, isCollapsed)
}