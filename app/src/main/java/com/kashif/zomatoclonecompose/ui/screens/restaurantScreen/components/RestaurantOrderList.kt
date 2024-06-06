package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.ItemsModel
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.recomemdedList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zDarkGray
import com.kashif.zomatoclonecompose.ui.theme.zDishLabelBg
import com.kashif.zomatoclonecompose.ui.theme.zDishLabelTextColor
import com.kashif.zomatoclonecompose.ui.theme.zRatingCardYellowBg
import com.kashif.zomatoclonecompose.ui.theme.zRatingCardYellowBorder
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zSelectedFilterRowItemBg
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 05,June,2024
 */

@Composable
fun RestaurantOrderList(recomemdedList: List<ItemsModel>) {
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {}
    }
    val heigh=recomemdedList.size*220
    LazyColumn(Modifier
        .height(height = heigh.dp)
        .nestedScroll(nestedScrollConnection)) {
        items(recomemdedList){item->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth().background(zWhite)
                    .padding(top = 3.dp, start = 10.dp, end = 10.dp, bottom = 18.dp)
            ) {
                DishDetailsColumn(item)
                DishImageColumn(item)
            }
        }
    }

}
@Composable
fun DishDetailsColumn(item: ItemsModel) {
//    var isFavourite by remember {
//        mutableStateOf(false)
//    }

    Column(
        modifier = Modifier.fillMaxWidth(0.64f)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

                Icon(
                    painter = painterResource(id = if(item.type==0)
                        R.drawable.veg_icon else if(item.type==1)
                            R.drawable.non_veg_icon else
                                R.drawable.egg_icon_type),
                    contentDescription = stringResource(R.string.veg_or_non_veg_icon),
                    tint = Color.Unspecified,
                    modifier = Modifier.size(25.dp)
                )

                if(item.category!=0){
                    Card(
                        modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(0.5.dp, zDishLabelTextColor),
                        backgroundColor = zDishLabelBg
                    ) {
                        Icon(
                            painter = painterResource(id = if(item.category==1) R.drawable.spicy_icon else  R.drawable.sweet_icon),
                            contentDescription = "spicy",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }


            if(item.category_type!=0){
                Card(
                    modifier = Modifier.padding(5.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(0.5.dp, zDishLabelTextColor),
                    backgroundColor = zDishLabelBg
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.bestseller),
                            color = zDishLabelTextColor,
                            modifier = Modifier.padding(1.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                }
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title,
            fontSize = Dimens.FontSize3,
            fontWeight = FontWeight.Bold,
            color = zBlack,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(end = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if(item.rate!=0.0f){
            Row (horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Card(
                    modifier = Modifier.padding(vertical = 5.dp),
                    shape = RoundedCornerShape(3.dp),
                    border = BorderStroke(0.5.dp, zRatingCardYellowBorder),
                    backgroundColor = zRatingCardYellowBg
                ) {
                    StarRating(rating = item.rate,  modifier = Modifier.padding(2.dp), onRatingChanged = {  })

                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = item.rating,
                    fontSize = Dimens.FontSize2,
                    fontWeight = FontWeight.Normal,
                    color = zBlack,

                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.price,
            fontSize = Dimens.FontSize3,
            fontWeight = FontWeight.Bold,
            color = zBlack,

        )
        Spacer(modifier = Modifier.height(8.dp))
            if(item.ingredian!!.isNotEmpty()){
                Text(text = item.ingredian,
                    fontSize = Dimens.FontSize2,
                    fontWeight = FontWeight.Normal,
                    color = zDarkGray,
                    maxLines = 2,
                    )
            }

    }
}

@Composable
fun DishImageColumn(item: ItemsModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(start = 10.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            // Image
            Image(
                painter = rememberImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .placeholder(R.drawable.placeholder_image)
                        .data(item.image)
                        .crossfade(true)
                        .build()
                ),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .align(Alignment.TopCenter)
                    .clip(RoundedCornerShape(10.dp))
            )

            // Card at the bottom
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp) // Adjust height as necessary
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.5.dp, Color.Red),
                backgroundColor = zSelectedFilterRowItemBg
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(3.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                       // verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "ADD",
                            fontSize = Dimens.FontSize5,
                            color = Color.Red,
                            modifier = Modifier.padding(2.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = zRedColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }




//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = "customisable",
//                    color = zDarkGray,
//                    fontSize = 11.sp
//                )
//            }

    }
}

@Preview(showBackground = false)
@Composable
fun showMostOrder(){
    RestaurantOrderList(recomemdedList)
}
