package com.kashif.zomatoclonecompose.navgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.ZomatoNavigator
import com.kashif.zomatoclonecompose.screens.countryPicker.CountryPickerScreen
import com.kashif.zomatoclonecompose.screens.loginScreen.LoginScreen
import com.yugesh.zomatoclone.screens.restaurantScreen.RestaurantScreen

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val navBarNavController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.LoginScreen.route) { //Route.LoginScreen.route
        composable(
            route = Route.LoginScreen.route,
            content = {
                LoginScreen(navHostController = navController,)
            })
        composable(
            route = Route.CountryPickerScreen.route,
            content = { CountryPickerScreen(navHostController = navController,pickedCountry = {}) })
        composable(
            route = Route.ZomatoNavigationGraph.route,
            content = {
                ZomatoNavigator(navHostController = navBarNavController)
            })

    }
}

