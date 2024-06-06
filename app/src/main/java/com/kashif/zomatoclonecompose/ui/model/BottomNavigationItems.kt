package com.kashif.zomatoclonecompose.ui.model

import androidx.annotation.DrawableRes

/**
 * Created by Mohammad Kashif Ansari on 02,June,2024
 */
data class BottomNavigationItems(val route:String, @DrawableRes val icon:Int,
                                 val text:String,val is_icon_exist:Boolean)
