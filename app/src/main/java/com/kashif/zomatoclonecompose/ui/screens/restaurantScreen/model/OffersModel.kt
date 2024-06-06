package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model

import androidx.compose.ui.graphics.Color
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zDarkBlueDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkBlueGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkGoldenDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zDarkGoldenGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightBlueDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightBlueGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightGoldenDividerGradient
import com.kashif.zomatoclonecompose.ui.theme.zLightGoldenGradient

/**
 * Created by Mohammad Kashif Ansari on 04,June,2024
 */
data class OffersModel(val icon:Int,
                       val title:String,
                       val desc:String,
                       val gradientDark: Color,
                       val gradientLight: Color,
                       val dividerDark: Color,
                       val dividerLight: Color
)
val offers= listOf(
    OffersModel(icon = R.drawable.percentage_badge,
        title = "40% OFF up to ₹80",
        desc = "Use code ONLY4U | above ₹159",
        zDarkBlueGradient,
        zLightBlueGradient,
        zDarkBlueDividerGradient,
        zLightBlueDividerGradient
    ),
    OffersModel(icon = R.drawable.lock_icon,
        title = "Free Delivery",
        desc = "join Gold to unlock",
        zDarkGoldenGradient,
        zLightGoldenGradient,
        zDarkGoldenDividerGradient,
        zLightGoldenDividerGradient
    ),
    OffersModel(icon = R.drawable.percentage_badge,
        title = "Flat ₹50 OFF",
        desc = "Use code TRYKFC | above ₹299",
        zDarkBlueGradient,
        zLightBlueGradient,
        zDarkBlueDividerGradient,
        zLightBlueDividerGradient
    ),
    OffersModel(icon = R.drawable.free_delivery_icon,
        title = "Free Delivery",
        desc = "above ₹1000",
        zDarkBlueGradient,
        zLightBlueGradient,
        zDarkBlueDividerGradient,
        zLightBlueDividerGradient
    ),
    OffersModel(icon = R.drawable.percentage_badge,
        title = "Flat ₹80 OFF",
        desc = "Use code GET100 | above ₹599",
        zDarkBlueGradient,
        zLightBlueGradient,
        zDarkBlueDividerGradient,
        zLightBlueDividerGradient
    )
)