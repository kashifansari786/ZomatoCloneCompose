package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 29,May,2024
 */
@Composable
fun LocationRow(onCLick:()->Unit) {
    Row(
        modifier = Modifier.padding(Dimens.Elevation),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //icon with location text
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(3.5f), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "location", tint = zRedColor)
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.Elevation).clickable {
                    Log.d("inside_location","onclick clickable")
                                       onCLick.invoke()
                }, horizontalAlignment = Alignment.Start) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Home", fontWeight = FontWeight.Bold, fontSize = Dimens.FontSize3, color = Color.Black)
                    Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding)) // Add space between icon and text
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24), // Replace with your icon resource
                        contentDescription = "Star Icon",
                        tint = Color.Black
                    )
                }
                Text(text = "opp to bhatia, Bhatia Restaurant, Shiwala",
                    fontWeight = FontWeight.Normal,
                    fontSize = Dimens.FontSize3,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
            }
        }
        Row (modifier = Modifier
            .weight(1.5f)
            .padding(start = 5.dp), verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier
                .size(width = 10.dp, height = 40.dp)
                .weight(0.5f)
                .padding(end = 5.dp)
                .background(Color.White, shape = RoundedCornerShape(Dimens.CornerShape))
                .border(Dimens.Border, Color.LightGray, RoundedCornerShape(Dimens.CornerShape)),
                contentAlignment = Alignment.Center){
                Icon(
                    modifier = Modifier.padding(start = Dimens.ExtraSmallPadding),
                    painter = painterResource(id = R.drawable.baseline_language_24), // Replace with your icon resource
                    contentDescription = "Star Icon",
                    tint = Color.Black
                )
            }
            Box(modifier = Modifier
                .weight(0.5f)
                .clip(CircleShape)
                .border(Dimens.Border, Color.LightGray, RoundedCornerShape(Dimens.Padding1)),
                contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(R.drawable.profile_1), // Replace with your image resource
                    contentDescription = "Location",
                    modifier = Modifier
                        .size(40.dp)
                    , contentScale = ContentScale.Crop
                )
            }
        }

    }
}