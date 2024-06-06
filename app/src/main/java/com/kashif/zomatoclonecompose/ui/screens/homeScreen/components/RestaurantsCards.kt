package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.RestaurantImage
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.models.RestaurantsList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zBlueColor
import com.kashif.zomatoclonecompose.ui.theme.zGolden
import com.kashif.zomatoclonecompose.ui.theme.zGreenRatingColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import com.kashif.zomatoclonecompose.ui.utils.Dot
import com.kashif.zomatoclonecompose.ui.utils.DottedDivider

/**
 * Created by Mohammad Kashif Ansari on 02,June,2024
 */
@Composable
fun RestaurantsCards(item: RestaurantsList,onClick:()->Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .shadow(8.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black)
            .height(300.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke() }
    ){
        AutoSlidingImageSlider(item.imageList,250.dp)

        //fav and visibility icons
        Box(modifier = Modifier.align(Alignment.TopEnd).padding(end = 20.dp, top = 10.dp)){
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Icon(painter = painterResource(id = R.drawable.heart_gray_empty),
                    contentDescription = "time",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(10.dp))
                Icon(painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                    contentDescription = "time",
                    modifier = Modifier.size(20.dp),
                    tint = zWhite
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.fillMaxWidth()){
                    CustomSteppedLayout()
                        Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
                            Icon(painter = painterResource(id = R.drawable.fortyfive_min),
                                contentDescription = "time",
                                modifier = Modifier.size(15.dp),
                                tint = Color.Unspecified)
                            Text(text = item.closeTime,
                                fontSize = Dimens.FontSize2,
                                fontWeight = FontWeight.Bold,
                                color = zBlack,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Dot()
                            Text(text = item.distance,
                                fontSize = Dimens.FontSize2,
                                fontWeight = FontWeight.Bold,
                                color = zBlack,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }

//                    Icon(painter = painterResource(id = R.drawable.card_layout_selector),
//                        contentDescription = "",
//                        tint = Color.Unspecified,
//                        modifier = Modifier.fillMaxWidth()
//                    )


                }
                Column(modifier = Modifier
                    .background(zWhite)
                    .fillMaxWidth()) {
                    //title row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp, end = 10.dp)

                    ) {
                        Text(
                            text = item.title,
                            fontSize = Dimens.FontSize5, // Use Dimens.FontSize5 if defined
                            fontWeight = FontWeight.Bold,
                            color = zBlack,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .weight(1f)
                        )

                        Spacer(modifier = Modifier.width(8.dp)) // Add some space between the texts

                        //rating box
                        Box(
                            modifier = Modifier
                                .background(zGreenRatingColor, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 4.dp, vertical = 4.dp)

                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = item.rating.toString(),
                                    fontSize = Dimens.FontSize3, // Use Dimens.FontSize5 if defined
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Icon(
                                    painter = painterResource(R.drawable.star), // Replace with your icon resource
                                    contentDescription = null, // Optional padding
                                    modifier = Modifier
                                        .padding(start = 3.dp)
                                        .size(15.dp),
                                    tint = zWhite // Ensure original icon colors are used
                                )
                            }

                        }
                    }
                    //category row
                    Row (horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = item.category,
                            fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                            fontWeight = FontWeight.Normal,
                            color = zBlack
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Dot()
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = item.category2,
                            fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                            fontWeight = FontWeight.Normal,
                            color = zBlack
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Dot()
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = item.priceForOne,
                            fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                            fontWeight = FontWeight.Normal,
                            color = zBlack
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    DottedDivider()
                    Spacer(modifier = Modifier.height(5.dp))

                    //discount column
                    Row (horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)){
                        if(item.isExtra){
                            Row (horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,){
                                Icon(painter = painterResource(id = R.drawable.extra_badge),
                                    contentDescription = "extrabadge",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = item.extra,
                                    fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                                    fontWeight = FontWeight.Bold,
                                    color = zGolden
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier
                                    .height(Dimens.MediumPadding24)
                                    .width(Dimens.Border)
                                    .padding(top = 5.dp, bottom = 5.dp)

                            )
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        Row (horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,){
                            Icon(painter = painterResource(id = R.drawable.percentage_badge),
                                contentDescription = "extrabadge",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = item.discount,
                                fontSize = Dimens.FontSize2, // Use Dimens.FontSize5 if defined
                                fontWeight = FontWeight.Bold,
                                color = zBlueColor
                            )
                        }

                    }
                }


            }
        }


    }

}

