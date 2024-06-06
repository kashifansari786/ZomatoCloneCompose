package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model

/**
 * Created by Mohammad Kashif Ansari on 05,June,2024
 */
data class YourOrderModel(
    val title:String,
    val price:String,
    val image:String,
    val orderText:String,
    val isCustomizable:Boolean,
    val type:Int//0=veg,1=nonveg
)

val yourOrderList= listOf(
    YourOrderModel(title = "Phirni",
        price = "₹60",
        image = "https://b.zmtcdn.com/data/dish_photos/6fe/d7c61f8a520a3aa449d8523307d7e6fe.png?fit=around|130:130&crop=130:130;*,*",
        orderText = "You ordered 6 months ago",
        isCustomizable = true,
        type = 0),
    YourOrderModel(title = "Special Chicken Tikka Biryani(3pec)",
        price = "₹310",
        image = "https://b.zmtcdn.com/data/dish_photos/551/4a02a3692c9b53b1272d3c0d2d4ac551.png?fit=around|130:130&crop=130:130;*,*",
        orderText = "You ordered 6 months ago",
        isCustomizable = true,
        type = 1),
    YourOrderModel(title = "Chicken Tikka Masala",
        price = "₹320",
        image = "https://b.zmtcdn.com/data/dish_photos/251/961157246f9aa44e2a686683e1128251.jpeg?fit=around|130:130&crop=130:130;*,*",
        orderText = "You rated 4 ",
        isCustomizable = false,
        type = 2),
)
