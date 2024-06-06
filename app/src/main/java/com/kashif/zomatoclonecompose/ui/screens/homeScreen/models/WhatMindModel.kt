package com.kashif.zomatoclonecompose.ui.screens.homeScreen.models

import com.kashif.zomatoclonecompose.R

/**
 * Created by Mohammad Kashif Ansari on 31,May,2024
 */
data class WhatMindModel(
    val image:String,
    val name:String,
    val id:Int
)

val mindList= listOf(
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/d0bd7c9405ac87f6aa65e31fe55800941632716575.png",
        name = "Pizza",id=1000),
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/37df381734b24f138af4a84fd7e4d4ec1716558578.jpeg",
        name = "Biryani",id=1001),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/ccb7dc2ba2b054419f805da7f05704471634886169.png",
        name = "Burger",id=1002),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/197987b7ebcd1ee08f8c25ea4e77e20f1634731334.png",
        name = "Chicken",id=1003),
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/4c7697178c268c50e1b1641fca205c231634401116.png",
        name = "Ice Cream",id=1004),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/d9766dd91cd75416f4f65cf286ca84331634805483.png",
        name = "Idli",id=1005),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/d5ab931c8c239271de45e1c159af94311634805744.png",
        name = "Cake",id=1006),
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/019409fe8f838312214d9211be010ef31678798444.jpeg",
        name = "North Indian",id=1007),
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/52eb9796bb9bcf0eba64c643349e97211634401116.png",
        name = "Thali",id=1008),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/c2f22c42f7ba90d81440a88449f4e5891634806087.png",
        name = "Rolls",id=1009),
    WhatMindModel(image = "https://b.zmtcdn.com/data/o2_assets/e444ade83eb22360b6ca79e6e777955f1632716661.png",
        name = "Fried Rice",id=1010),
    WhatMindModel(image = "https://b.zmtcdn.com/data/dish_images/91c554bcbbab049353a8808fc970e3b31615960315.png",
        name = "Noodles",id=1011)
)
