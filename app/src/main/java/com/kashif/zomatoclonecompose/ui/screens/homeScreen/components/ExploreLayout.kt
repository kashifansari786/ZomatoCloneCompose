package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zBlueColor
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import kotlinx.coroutines.delay

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */

data class Offer(val image:Int,val title:String)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExploreLayout() {

    val offers = listOf(
        Offer(R.drawable.discount_badge, "Flat Discount"),
        Offer(R.drawable.offer_badge, "Up to 60% OFF"),
        Offer(R.drawable.more_discount_badge, "& More")
    )

    var currentIndex by remember { mutableStateOf(0) }

    // Launch coroutine to update the index every 3 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000L)
            currentIndex = (currentIndex + 1) % offers.size
        }
    }

    val currentOffer = offers[currentIndex]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .height(150.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                AnimatedContent(
                    targetState = currentOffer.image,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(1000)) with fadeOut(animationSpec = tween(1000))
                    }
                ) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "discount_badge",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Text(
                    text = "Offers",
                    fontSize = Dimens.FontSize5, // Use Dimens.FontSize5 if defined
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                )

                Spacer(modifier = Modifier.width(4.dp)) // Add some space between the texts
                AnimatedContent(
                    targetState = currentOffer.title,
                    transitionSpec = {
                        (slideInVertically { it } + fadeIn() with slideOutVertically { -it } + fadeOut())
                            .using(SizeTransform(clip = false))
                    }
                ) { text ->
                    Text(
                        text = text,
                        fontSize = Dimens.FontSize2, // Use Dimens.FontSize2 if defined
                        fontWeight = FontWeight.Normal,
                        color = zBlueColor,
                        maxLines = 1,
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .height(150.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.top_ten_badge),
                    contentDescription = "top 10",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = "Top 10",
                    fontSize = Dimens.FontSize5, // Use Dimens.FontSize5 if defined
                    fontWeight = FontWeight.Bold,
                    color = zBlack,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(4.dp)) // Add some space between the texts
                Text(
                    text = "Local Restaurants",
                    fontSize = Dimens.FontSize2, // Use Dimens.FontSize2 if defined
                    fontWeight = FontWeight.Normal,
                    color = zBlack,
                    maxLines = 1,
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .height(150.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.zpl_badge),
                    contentDescription = "zpl badge",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = "Result out!",
                    fontSize = Dimens.FontSize5, // Use Dimens.FontSize5 if defined
                    fontWeight = FontWeight.Bold,
                    color = zBlack,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(4.dp)) // Add some space between the texts
                Text(
                    text = "Check now",
                    fontSize = Dimens.FontSize2, // Use Dimens.FontSize2 if defined
                    fontWeight = FontWeight.Normal,
                    color = zBlack,
                    maxLines = 1,
                )
            }
        }
    }
}