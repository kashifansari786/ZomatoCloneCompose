package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.RestaurantScreenBottomModel
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import com.kashif.zomatoclonecompose.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Mohammad Kashif Ansari on 04,June,2024
 */

@Composable
fun RestaurantBottomBar(
    bottomList: List<RestaurantScreenBottomModel>,
    selectedIndex: Int, // Pass selected index
    onOptionClicked: (RestaurantScreenBottomModel) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val state= rememberLazyListState()
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(zWhite)
        .navigationBarsPadding()
    ) {
        LazyRow(state=state) {
            itemsIndexed(bottomList) { index, list ->
                ItemsSliders(
                    list = list,
                    onOptionClicked = {
                        onOptionClicked(it)
                    },
                )
            }
//            items(bottomList) { list ->
//                ItemsSliders(list, onOptionClicked)
//            }
        }
        LaunchedEffect(key1 = selectedIndex) {
            coroutineScope.launch {
                state.animateScrollToItem(selectedIndex)
            }
        }

        Row(
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)
                )
                .align(Alignment.CenterEnd)
                .padding(start = 10.dp)
                .clickable { /* Handle click */ },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.catelary_icon), contentDescription = "catlary", tint = Color.Unspecified)
            Text(
                text = "Menu",
                fontSize = Dimens.FontSize4, // Adjust font size as needed
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}


@Composable
fun ItemsSliders(list: RestaurantScreenBottomModel, onOptionClicked: (RestaurantScreenBottomModel) -> Unit) {
    val backgroundColor = animateColorAsState(targetValue = if (list.selected) Color.LightGray else Color.White)
    val textColor = animateColorAsState(targetValue = if (list.selected) Color.Black else Color.LightGray)

    Box(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onOptionClicked(list) }
            .background(
                color = backgroundColor.value,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = list.title,
            fontSize = Dimens.FontSize4, // Adjust font size as needed
            fontWeight = FontWeight.Normal,
            color = textColor.value,
            modifier = Modifier.padding(10.dp)
        )
    }
}