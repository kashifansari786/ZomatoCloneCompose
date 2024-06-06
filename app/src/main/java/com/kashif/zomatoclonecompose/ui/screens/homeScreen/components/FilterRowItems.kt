package com.kashif.zomatoclonecompose.screens.homeScreen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.ui.graphics.vector.ImageVector
import com.kashif.zomatoclonecompose.R

enum class FilterRowItems(
    val text: String,
    val leadingIcon: Int? = null,
    val trailingIcon: ImageVector? = null
) {
    SORT(
        text = "Sort",
        leadingIcon =  R.drawable.sort_icon,
        trailingIcon = Icons.Filled.ArrowDropDown,
    ),
    FAST_DELIVERY(
        text = "Near and Fast",
        leadingIcon = R.drawable.new_icon,
    ),
    GREAT_OFFERS(
        text = "Great Offers"
    ),
    RATING_4_PLUS(
        text = "Rating 4.0+"
    ),
    PREVIOUS_ORDER(
        text = "Previously Ordered"
    ),
    PURE_VEG(
        text = "100% Veg-only"
    ),
    CUISINES(
        text = "Cuisines",
        trailingIcon = Icons.Filled.ArrowDropDown,
    ),
    Filter(
        text = "Filter",
        leadingIcon = R.drawable.sort_icon,
        trailingIcon = Icons.Filled.ArrowDropDown
    ),
    VEG(
        text = "Veg",
        leadingIcon = R.drawable.veg_icon,
    ),
    EGG(
        text = "Egg",
        leadingIcon = R.drawable.egg_icon,
    ),
    NONVEG(
        text = "Non-Veg",
        leadingIcon = R.drawable.non_veg_icon,
    ),
    BESTSELLER(
        text = "Bestseller",
        leadingIcon = R.drawable.best_seller_icon,
    ),
    RATING(
        text = "Rating 4+",
        leadingIcon = R.drawable.rate_icon,
    ),
    SPICY(
        text = "Spicy",
        leadingIcon = R.drawable.spicy_icon,
    ),
    SWEET(
        text = "Sweets",
        leadingIcon = R.drawable.sweet_icon,
    ),
    KIDS(
        text = "Kid\'s choice",
        leadingIcon = R.drawable.kids_icon,
    ),
}

fun getAllHomeScreenFilterItems(): List<FilterRowItems> {
    return listOf(
        FilterRowItems.SORT,
        FilterRowItems.FAST_DELIVERY,
        FilterRowItems.GREAT_OFFERS,
        FilterRowItems.RATING_4_PLUS,
        FilterRowItems.PREVIOUS_ORDER,
        FilterRowItems.PURE_VEG,
        FilterRowItems.CUISINES,
        //HomeScreenFilterItems.MORE
    )
}
fun getAllRestaurantFilterItems(): List<FilterRowItems> {
    return listOf(
        FilterRowItems.Filter,
        FilterRowItems.VEG,
        FilterRowItems.EGG,
        FilterRowItems.NONVEG,
        FilterRowItems.BESTSELLER,
        FilterRowItems.RATING,
        FilterRowItems.SPICY,
        FilterRowItems.KIDS,
        FilterRowItems.SWEET,
        //HomeScreenFilterItems.MORE
    )
}
