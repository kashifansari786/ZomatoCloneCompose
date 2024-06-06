package com.kashif.zomatoclonecompose.ui.screens.homeScreen.models

import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.RestaurantImage

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */
data class RestaurantsList(
    val title:String,
    val rating:Float,
    val isExtra:Boolean,
    val extra:String,
    val discount:String,
    val distance:String,
    val closeTime:String,
    val category:String,
    val category2:String,
    val priceForOne:String,
    val imageList:List<RestaurantImage>
)

val restaurantList= listOf(
    RestaurantsList(title = "TCF-The Chakhna Factory",
        rating = 4.2f,
        isExtra = true,
        extra = "Extra 15% OFF",
        discount = "40% OFF up to ₹80",
        distance = "3km",
        closeTime = "38 mins",
        category = "North Indian",
        category2 = "Chinese",
        priceForOne = "₹300 for one",
        imageList = listOf(
            RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/3/20732153/b6ddde51d1b8ffa3b619b6e8e08b7ce0_o2_featured_v2.jpg?fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/dish_photos/937/6bd5c728351781126a159b3988a4a937.jpg?output-format=webp",
                title = "Chicken Tikka Biryani . ₹240"
            ),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/dish_photos/b68/a9931ed5fdbddee442e519cc0a0ebb68.png?output-format=webp",
                title = "Hara Bhara Kebab . ₹220"
            ),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/dish_photos/685/442de9c16d4421d2c5ff9f47553fa685.jpg?output-format=webp",
                title = "Lemon Garlic Chicken . ₹299"
            ),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/dish_photos/a7e/c7a304a63550332141ad90557b031a7e.jpg?output-format=webp",
                title = "Paneer Tikka . ₹260"
            )
        )
    ),
    RestaurantsList(title = "Tunday Kababi",
        rating = 4.2f,
        isExtra = false,
        extra = "",
        discount = "Flat ₹100 OFF above ₹199",
        distance = "1km",
        closeTime = "19 mins",
        category = "Mughlai",
        category2 = "Kebab",
        priceForOne = "₹200 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/9/2300029/44908ca34795f80b663d827fbd7e4913.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/0e3/15fbfcbd3b9b7726af05f15fad6100e3_1528655255.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Mutton Biryani . ₹143"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/3a4/e26fec40c0355373ae1f4556611a43a4_1485252378.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Mutton Tunday Kabab Combo . ₹189"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/947/18dbad54fee7c47808e92fa75cf3e947_1564860681.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Chicken Boti Kabab . ₹300"))
    ),
    RestaurantsList(title = "Talk of The Town - Gumti 5",
        rating = 4.3f,
        isExtra = true,
        extra = "Extra 15& OFF",
        discount = "60% OFF up to ₹120",
        distance = "3.5km",
        closeTime = "31 mins",
        category = "Chinese",
        category2 = "Burger",
        priceForOne = "₹200 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/9/2300179/c5c5318e6b3b87c8017ce4a251929c26.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/9/2300179/a7452876346b34f3f8d951cae4187ee9.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Veg Chowmine . ₹155"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/333/158c151372bd846555f38103f42b6333_1564167740.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Manchurian Gravy . ₹250"),
            )
    ),
    RestaurantsList(title = "Zyka (Parade)",
        rating = 3.9f,
        isExtra = false,
        extra = "",
        discount = "60% OFF up tp ₹110 + ₹25 cashback",
        distance = "1km",
        closeTime = "23 mins",
        category = "North Indian",
        category2 = "Biryani",
        priceForOne = "₹250 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/2/18209832/1535f5425b0a25676593b0f1b3c18aef_o2_featured_v2.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/2/18209832/dfe641b27dbd33452a97bfbb4747c2f0.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Kadai Chicken . ₹300"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/d4b/7129420a4cd78faf189bba6befc2bd4b_1592068893.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Chicken Biryani . ₹200"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/0ec/dc6710681af1e4e1b928e378879b60ec_1542727176.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Roasted Chicken(dry) . ₹190"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/36b/8281cd4ff77d9806439d36558576e36b_1547565027.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Chilli Paneer(dry) . ₹300"))
    ),
    RestaurantsList(title = "Chhappan Bhog",
        rating = 4.2f,
        isExtra = false,
        extra = "",
        discount = "Flat ₹125 OFF + ₹25 cashback",
        distance = "5km",
        closeTime = "30 mins",
        category = "100% Veg-only",
        category2 = "Mithai",
        priceForOne = "₹100 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/5/2300785/6e90a8f5b39e06282f6422df20068e52_o2_featured_v2.png?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/53f/1fab204efe97759974b06484775ba53f_1589013455.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Kachori Thali . ₹150"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/5/2300785/2d07e5d00230960d48c89ac54c15ba62.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Kaju Katli . ₹1500"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/reviews_photos/419/e6ddc1b18ede211f99876840d3456419_1575365487.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Dahi Bhalle . ₹400"))
    ),
    RestaurantsList(title = "The Hazelnut Factory",
        rating = 4.2f,
        isExtra = false,
        extra = "",
        discount = "30% OFF up to ₹75",
        distance = "1km",
        closeTime = "22 mins",
        category = "Cafe",
        category2 = "Coffee",
        priceForOne = "₹250 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/0/20911740/e378fa041ffa5d9f74c07396772391d1_o2_featured_v2.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/0/20911740/b4cd56d5293b6adc3c84bc1f0ada3011.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Assorted Baklava Box . ₹1144"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/0/20911740/a81cd4662a34f617bf0e4b247d667a75.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = ""))
    ),
    RestaurantsList(title = "KFC",
        rating = 4.0f,
        isExtra = false,
        extra = "",
        discount = "40% OFF up to ₹80",
        distance = "1km",
        closeTime = "26 mins",
        category = "Burger",
        category2 = "Fast Food",
        priceForOne = "₹300 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/chains/5/2300035/93776f3249312397e2c2ba274b4812ec.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/5/2300035/0e79614ea14113b8b3d4b48574293d00.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Ultimate Savings Chicken . ₹729"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/5/2300035/99ef15aa42501a40de7753f503a116ce.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Mixed Chicken Zinger Burger . ₹369"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/5/2300035/6e5cb6568c791166c6e73056641ce4b1.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Hot Chicken Wings - 4pc . ₹179"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/5/2300035/9410759d611db9c62c3acc23c1f27e06.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Chicken Mingles Bucket . ₹399"))
    ),
    RestaurantsList(title = "La Pino\'z Pizza",
        rating = 3.9f,
        isExtra = false,
        extra = "",
        discount = "50% OFF up to ₹100",
        distance = "3km",
        closeTime = "28 mins",
        category = "Pizza",
        category2 = "Pasta",
        priceForOne = "₹250 for one",
        imageList = listOf(RestaurantImage(
            image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/eac5d48527700f6ea1bcfbb2094456d0.jpg?output-format=webp&fit=around|771.75:416.25&crop=771.75:416.25;*,*",
            title = ""),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/d0c4da07464eaaad3dc713134ab4fe3d.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Margherita Pizza . ₹134"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/0d9cfb20645f12903722023ad4a89ac8.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Paneer Tikka Butter Masala . ₹263"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/68df91206060b1664c4d0cf28c5811d5.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Cheezy-7 Pizza . ₹286"),
            RestaurantImage(
                image = "https://b.zmtcdn.com/data/pictures/chains/6/2304946/ef153913a3e43302253ba6e4ac8ae630.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
                title = "Burn To Hell Pizza . ₹263"))
    )
)
