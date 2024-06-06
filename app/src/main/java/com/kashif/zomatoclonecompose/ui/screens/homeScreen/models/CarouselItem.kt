package com.kashif.zomatoclonecompose.ui.screens.homeScreen.models

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */
data class CarouselItem(
    val image:String,
    val discount:String,
    val title:String,
    val rating:Float
)

val carousalList= listOf(
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/chains/3/2301603/7fe3efeedbae974394a93458d0f1616c.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
        discount = "Flat ₹125 OFF + ₹25 cashback",
        title = "R S Bhojnalaya",
        rating = 3.8f),
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/2/18209832/1535f5425b0a25676593b0f1b3c18aef_o2_featured_v2.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
        discount = "60% OFF up to ₹110 + ₹25 cashback",
        title = "Zyka (Parade)",
        rating = 3.9f),
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/chains/0/19247830/b36a97995debe74a623c762f94cdb28b.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
        discount = "20% OFF up to ₹50",
        title = "Al-Baik.Com",
        rating = 4.1f),
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/eac5d48527700f6ea1bcfbb2094456d0.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
        discount = "50% OFF up to ₹100",
        title = "La Pino\'z Pizza",
        rating = 3.9f),
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/6/20824796/cea706eacafae2b760a4f54504ac14f4.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
        discount = "Pizza Junction",
        title = "Flat ₹125 OFF above ₹199",
        rating = 4.1f),
    CarouselItem(image = "https://b.zmtcdn.com/data/pictures/9/2300689/d6cf676855eb0ff15dde138f3fb2e731_featured_v2.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
        discount = "50% OFF up to ₹100",
        title = "Keventers - Milkshakes & Desserts",
        rating = 4.3f),

)
