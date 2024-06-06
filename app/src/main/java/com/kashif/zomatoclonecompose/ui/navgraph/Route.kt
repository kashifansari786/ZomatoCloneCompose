package com.kashif.zomatoclonecompose.navgraph

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
sealed class Route(val route:String) {

    object CountryPickerScreen:Route(route = "countryPickerScreen")
    object LoginScreen:Route(route = "loginScreen")
    object HomeScreen:Route(route = "homeScreen")
    object RestaurantScreen:Route(route = "restaurantScreen")
    object DiningScreen:Route(route = "diningScreen")
    object MoneyScreen:Route(route = "moneyScreen")
    object BlinkitScreen:Route(route = "blinkitScreen")
    object LocationsScreen:Route(route = "locationScreen")
    //sub route
    object LoginNavigationGraph:Route(route = "loginNavigationGraph")
    object ZomatoNavigationGraph:Route(route = "zomatoNavigationGraph")
    object ZomatoNavigator:Route(route = "zomatoNavigator")
}