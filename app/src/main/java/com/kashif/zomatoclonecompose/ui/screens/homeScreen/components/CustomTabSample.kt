package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 30,May,2024
 */
@Composable
fun CustomTabSample( onClick: (index: Int) -> Unit) {
    val (selected, setSelected) = remember {
        mutableStateOf(0)
    }
    onClick(selected)
    CustomTab(
        items = listOf("Recommended", "Favourites"),
        selectedItemIndex = selected,
        onClick = setSelected,
    )
}
@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 120.dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing),
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
        , contentAlignment = Alignment.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(zWhite, shape = RoundedCornerShape(Dimens.Elevation))
                .border(Dimens.Border, zLightGray, RoundedCornerShape(Dimens.Elevation)),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    selectedItemIndex=index,
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}
@Composable
private fun MyTabItem(
    selectedItemIndex:Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            zBlack
        } else {
            zLightGray
        },
        animationSpec = tween(easing = LinearEasing),
    )
    val tabColor: Color by animateColorAsState(
        targetValue = if(isSelected)
            zRedColor.copy(alpha = 0.2f)
        else
            zWhite
        , animationSpec = tween(easing = LinearEasing)
    )
    val borderStroke = if (isSelected) {
        BorderStroke(2.dp, zRedColor)
    } else {
        BorderStroke(1.dp, zWhite)
    }
    Row(modifier = Modifier.width(tabWidth).background(
        tabColor, shape = if (selectedItemIndex == 0)
            RoundedCornerShape(topStart = Dimens.Elevation, bottomStart = Dimens.Elevation)
        else
            RoundedCornerShape(topEnd = Dimens.Elevation, bottomEnd = Dimens.Elevation)
    )
        .border(
            borderStroke, shape = if (selectedItemIndex == 0)
                RoundedCornerShape(topStart = Dimens.Elevation, bottomStart = Dimens.Elevation)
            else
                RoundedCornerShape(topEnd = Dimens.Elevation, bottomEnd = Dimens.Elevation)
        ), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        if(selectedItemIndex==1){
            Icon(painter = if(isSelected) painterResource(id = R.drawable.heart_filled) else painterResource(
                id = R.drawable.heart_empty
            ), contentDescription = "favourites", modifier = Modifier.size(20.dp).padding(end = 5.dp))
        }
        Text(
            modifier = Modifier

                .clickable {
                    onClick()
                }

                .padding(
                    vertical = 8.dp,
                ),
            text = text,
            fontSize = Dimens.FontSize2,
            color = tabTextColor,
            textAlign = TextAlign.Center,
        )
    }

}