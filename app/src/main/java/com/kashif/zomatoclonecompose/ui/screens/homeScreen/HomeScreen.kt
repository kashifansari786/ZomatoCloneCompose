package com.kashif.zomatoclonecompose.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.screens.homeScreen.components.HomeScreenFilterItemRow
import com.kashif.zomatoclonecompose.screens.homeScreen.components.getAllHomeScreenFilterItems
import com.kashif.zomatoclonecompose.screens.loginScreen.components.OrTextDivider
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.CustomTabSample
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.ExpandedTopBar
import com.kashif.zomatoclonecompose.ui.utils.GetScreenHeight
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.CarouselWithIndicators
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.ExploreLayout
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.RecomendedOrFavrouitesList
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.RestaurantsCards
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.WhatsMindList
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.restaurantList
import com.kashif.zomatoclonecompose.ui.utils.Dimens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun HomeScreen(navHostController: NavHostController, scrollState: ScrollState) {
    val screenHeight = GetScreenHeight()
    setBarColors()

    var parameter by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier
        .fillMaxSize()
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ExpandedTopBar(screenHeight)
            OrTextDivider(R.string.for_you)
            CustomTabSample(onClick = { parameter = it })
            parameter?.let { RecomendedOrFavrouitesList(navHostController,it) }
            OrTextDivider(R.string.explore)
            ExploreLayout()
            OrTextDivider(R.string.whatsa_mind)
            WhatsMindList()
            OrTextDivider(R.string.in_spotlight)
            CarouselWithIndicators()

            OrTextDivider(R.string.all_restaurants)
            HomeScreenFilterItemRow(categories = getAllHomeScreenFilterItems())
//            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "1612 restaurants delivering to you",
                fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
            )
            Text(
                text = "FEATURED",
                fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            AllRestaurantsList(navHostController)
            Spacer(modifier = Modifier.height(50.dp))
        }


    }
}




@Composable
fun AllRestaurantsList(navHostController: NavHostController) {
    val height= restaurantList.size*300
    LazyColumn(modifier = Modifier.height(height.dp)) {
        items(restaurantList){item->
            RestaurantsCards(item, onClick = {
                navHostController.navigate(Route.RestaurantScreen.route)
            })
        }
    }
}



@Composable
private fun setBarColors() {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController) {
        systemUiController.setNavigationBarColor(color = Color.Black, darkIcons = true)
        systemUiController.setStatusBarColor(color = Color.Transparent, darkIcons = true)
        onDispose { }
    }
}

//@Preview
//@Composable
//private fun CollapsedTopBarPreview() {
//    Column {
//        CollapsedTopBar(isCollapsed = true)
//        Spacer(Modifier.height(16.dp))
//        CollapsedTopBar(isCollapsed = false)
//    }
//}

@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {
//    val navHostController:NavHostController= rememberNavController()
//    val scrollState = rememberLazyListState()
//    HomeScreen(navHostController,scrollState)
    //AllRestaurantsList()
   // HomeScreen(navHostController, isCollapsed)
}

