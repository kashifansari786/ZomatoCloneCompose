package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model

/**
 * Created by Mohammad Kashif Ansari on 05,June,2024
 */
data class MostTogetherModel(
    val type:Int,
    val title:String,
    val price:String,
    val desc:String,
    val image1:String,
    val image2:String
)
val mostItemList= listOf(
    MostTogetherModel(type = 1,
        title = "Mutton Tunday Kabab combo + Mughlai Paratha",
        price = "₹216",
        desc = "Ordered by 150+ customers",
        image1 = "https://b.zmtcdn.com/data/dish_photos/85f/44c8f9c885530a313aa1a793b182685f.jpg?fit=around|130:130&crop=130:130;*,*",
        image2 = "https://b.zmtcdn.com/data/dish_photos/569/f7831b0a98c03f96c450aefad3e19569.jpg?fit=around|130:130&crop=130:130;*,*"),
    MostTogetherModel(type = 1,
        title = "Buffalo Tunday Galawati Kabab + Mughlai Paratha",
        price = "₹116",
        desc = "Ordered by 140+ customers",
        image1 = "https://b.zmtcdn.com/data/dish_photos/a35/f5f40ce71df45fe59f22cc943f9e8a35.jpg?fit=around|130:130&crop=130:130;*,*",
        image2 = "https://b.zmtcdn.com/data/dish_photos/569/f7831b0a98c03f96c450aefad3e19569.jpg?fit=around|130:130&crop=130:130;*,*"),
    MostTogetherModel(type = 1,
        title = "Mutton Tunday Galawati Kabab [4 Pieces] + Mughlai Paratha",
        price = "₹176",
        desc = "Ordered by 90+ customers",
        image1 = "https://b.zmtcdn.com/data/dish_photos/4c6/4f2cb1bfb215d0af454e65291aec74c6.jpg?fit=around|130:130&crop=130:130;*,*",
        image2 = "https://b.zmtcdn.com/data/dish_photos/569/f7831b0a98c03f96c450aefad3e19569.jpg?fit=around|130:130&crop=130:130;*,*"),
    MostTogetherModel(type = 1,
        title = "Buffalo Tunday Galawati Kabab [4 Pieces] + Mughlai Paratha",
        price = "₹112",
        desc = "Ordered by 80+ customers",
        image1 = "https://b.zmtcdn.com/data/dish_photos/07c/5fd1eda555f88ad987caf728780aa07c.jpg?fit=around|130:130&crop=130:130;*,*",
        image2 = "https://b.zmtcdn.com/data/dish_photos/569/f7831b0a98c03f96c450aefad3e19569.jpg?fit=around|130:130&crop=130:130;*,*"),
)
