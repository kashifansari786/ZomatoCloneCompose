package com.kashif.zomatoclonecompose

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.screens.diningScreen.DiningScreen
import com.kashif.zomatoclonecompose.screens.homeScreen.HomeScreen
import com.kashif.zomatoclonecompose.ui.blinkitScreen.BlinkitScreen
import com.kashif.zomatoclonecompose.ui.model.BottomNavigationItems
import com.kashif.zomatoclonecompose.ui.moneyScreen.MoneyScreen
import com.kashif.zomatoclonecompose.ui.screens.LocationScreen.LocationScreen
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.CollapsedHomeTopBar
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zSystemTopAppBarBgColor
import com.kashif.zomatoclonecompose.ui.utils.Dimens.COLLAPSED_TOP_BAR_HEIGHT
import com.kashif.zomatoclonecompose.ui.utils.GetScreenHeight
import com.yugesh.zomatoclone.screens.restaurantScreen.RestaurantScreen

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZomatoNavigator(navHostController: NavHostController){


    // State of bottomBar, set state to false, if current page route is "car_details"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val scrollState = rememberScrollState()
    val screenHeight = GetScreenHeight()
    val overlapHeightPx = with(LocalDensity.current) {
        screenHeight.toPx()/3  - COLLAPSED_TOP_BAR_HEIGHT.toPx()
    }
    val backstackState=navHostController.currentBackStackEntryAsState().value
    var isCollapsed by remember { mutableStateOf(false) }

    LaunchedEffect(scrollState.value) {
        isCollapsed = scrollState.value > overlapHeightPx
    }

    val isBottomBarVisible= remember(key1 = backstackState) {
        backstackState?.destination?.route==Route.HomeScreen.route ||
                backstackState?.destination?.route==Route.DiningScreen.route
                || backstackState?.destination?.route==Route.MoneyScreen.route
                || backstackState?.destination?.route==Route.BlinkitScreen.route
    }
    Scaffold(
        backgroundColor = zSystemTopAppBarBgColor,
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            // BottomNavBar(navController = navController, navigator = navigator)
            if(isBottomBarVisible && !isCollapsed){
                bottomBarState.value = true
                backstackState?.let {
                    BottomBar(
                        navController = navHostController,
                        bottomBarState = bottomBarState,
                        isCollapsed = isCollapsed,
                        backstackState = it
                    )
                }
            }


        }
    ) {
        if (isBottomBarVisible) {
            CollapsedHomeTopBar(
                navHostController = navHostController,
                modifier = Modifier
                    .zIndex(1f)
                    .background(color = Color.Transparent),
                isCollapsed = isCollapsed
            )
        }

        val bottomPadding=it.calculateBottomPadding()
        NavHost(navController = navHostController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)) {
            composable(route=Route.HomeScreen.route) {
                HomeScreen(navHostController,scrollState)
            }
            composable(route=Route.DiningScreen.route) {
                DiningScreen(navHostController)
            }
            composable(route=Route.MoneyScreen.route) {
                MoneyScreen(navHostController)
            }
            composable(route=Route.BlinkitScreen.route) {
                BlinkitScreen(navHostController)
            }
            composable(route=Route.LocationsScreen.route) {
                LocationScreen()
            }
            composable(route=Route.RestaurantScreen.route) {
                RestaurantScreen()
            }
    }
}
}

private fun navigateToTop(navController: NavController, route:String){
    navController.navigate(route = route){
        navController.graph.startDestinationRoute?.let {homeScreen->
            popUpTo(homeScreen){
                saveState=true
            }
            restoreState=true
            launchSingleTop=true
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>,
    isCollapsed: Boolean,
    backstackState:NavBackStackEntry
) {
    val bottomBarHeight: Dp by animateDpAsState(
        if (isCollapsed) 0.dp else 100.dp
    )
    val bottomNavigationItems= remember {
        listOf(
            BottomNavigationItems(route=Route.HomeScreen.route,icon = R.drawable.delivery_icon, text = "Delivery",false),
            BottomNavigationItems(route=Route.DiningScreen.route,icon = R.drawable.dining_icon, text = "Dining",false),
            BottomNavigationItems(route=Route.MoneyScreen.route,icon = R.drawable.money_icon, text = "Money",false),
            BottomNavigationItems(route=Route.BlinkitScreen.route,icon = R.drawable.blinkit_icon, text = "",true)
        )
    }


    val currentRoute = backstackState?.destination?.route

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                modifier = Modifier
                    .height(bottomBarHeight)
                    .navigationBarsPadding(),
                backgroundColor = Color.White,
                contentColor = Color.White
            ) {
                bottomNavigationItems.forEach { item ->
                    BottomNavigationItem(

                        icon = {
                            val iconSize = if (item.text.isNotEmpty()) 20.dp else 80.dp
                            Icon(painterResource(id = item.icon),
                            contentDescription = item.text,
                            modifier = Modifier.size(iconSize),
                            tint = Color.Unspecified
                            ) },
                        label = { Text(text = item.text) },
                        selectedContentColor = zRedColor,
                        unselectedContentColor = Color.Gray.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                            /* Add code later */

                        }
                    )
                }
            }

        }
    )
}


