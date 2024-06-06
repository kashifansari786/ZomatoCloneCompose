package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kashif.zomatoclonecompose.navgraph.Route

/**
 * Created by Mohammad Kashif Ansari on 30,May,2024
 */
@Composable
fun CollapsedHomeTopBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    isCollapsed: Boolean
) {

    val color: Color by animateColorAsState(
        if (isCollapsed) Color.White else Color.Transparent
    )
    val height: Dp by animateDpAsState(
        if (isCollapsed) 100.dp else 150.dp
    )

    Box(
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .height(height)
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            if (!isCollapsed) {
                LocationRow(onCLick = {
                    Log.d("inside_location","onclick row")
                    navHostController.navigate(
                        route = Route.LocationsScreen.route
                    )
                })
            }
            SearchBarWithSwitch()
        }
    }
}