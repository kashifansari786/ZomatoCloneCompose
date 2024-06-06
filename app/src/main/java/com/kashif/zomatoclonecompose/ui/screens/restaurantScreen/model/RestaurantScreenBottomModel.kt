package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Created by Mohammad Kashif Ansari on 02,June,2024
 */
data class RestaurantScreenBottomModel(
    val initialSelectedValue:Boolean,
    val title:String
){
    var selected by mutableStateOf(initialSelectedValue)
}
 val _bottomList= listOf(
    RestaurantScreenBottomModel(initialSelectedValue = true, title = "Your Orders and Favourites"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Most ordered together"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Recommended for you"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Match Day Combos"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Tunday Kababi Specials"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Barbeque & Starters"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Main Course"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Tunday\'s Special Biryani"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Rolls"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Breads"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Add on\'s & Extra"),
    RestaurantScreenBottomModel(initialSelectedValue = false,title = "Raw Keema"),
).toMutableList()
val bottomList: List<RestaurantScreenBottomModel>
    get() = _bottomList
