package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.MostTogetherModel
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.mostItemList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.yourOrderList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zDishLabelBg
import com.kashif.zomatoclonecompose.ui.theme.zDishLabelTextColor
import com.kashif.zomatoclonecompose.ui.theme.zGolden
import com.kashif.zomatoclonecompose.ui.theme.zGreenColor
import com.kashif.zomatoclonecompose.ui.theme.zItemAddButtonBg
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 05,June,2024
 */
@Composable
fun MostOrderItems(mostItemList: List<MostTogetherModel>) {
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {}
    }
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .nestedScroll(nestedScrollConnection)) {
            items(mostItemList){item->
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .background(zWhite)
                        .width(200.dp)
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(10.dp)),
                    //.height((LocalConfiguration.current.screenWidthDp / 3.8).dp),
                    backgroundColor = zWhite
                ) {
                    Column(horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(item.image1)
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(R.drawable.placeholder_image),
                                    error = painterResource(R.drawable.placeholder_image),
                                    contentDescription = item.title,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .size(width = 100.dp, height = 80.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 10.dp,
                                                bottomStart = 10.dp
                                            )
                                        )
                                )

                                  Spacer(modifier = Modifier.width(2.dp))  // Adjust the width as needed for spacing



                                // Spacer(modifier = Modifier.width(4.dp))  // Adjust the width as needed for spacing

                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(item.image2)
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(R.drawable.placeholder_image),
                                    error = painterResource(R.drawable.placeholder_image),
                                    contentDescription = item.title,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .size(width = 100.dp, height = 80.dp)
                                        .clip(
                                            RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                                        )
                                )
                            }
                            Box (modifier = Modifier.align(Alignment.Center).clip(RoundedCornerShape(10.dp))){
                                Icon(
                                    imageVector = Icons.Default.Add, // Replace with your icon resource
                                    contentDescription = "Your Icon",
                                    tint = zLightGray,
                                    modifier = Modifier
                                        .size(10.dp) // Adjust size as needed
                                        .background(zWhite)
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row (horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 8.dp)){
                            Icon(painter = painterResource(id = if(item.type==0) R.drawable.veg_icon else R.drawable.non_veg_icon),
                                contentDescription ="icons", tint = Color.Unspecified, modifier = Modifier.size(15.dp) )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = item.desc,
                                fontSize = Dimens.FontSize1,
                                fontWeight = FontWeight.Normal,
                                color = zGolden,
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = item.title,
                            fontSize = Dimens.FontSize2,
                            fontWeight = FontWeight.Normal,
                            color = zBlack,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                            Text(text = item.price,
                                fontSize = Dimens.FontSize1,
                                fontWeight = FontWeight.Bold,
                                color = zBlack,
                                modifier = Modifier.weight(1f)

                            )


                                    Row(
                                        modifier = Modifier
                                            .width(80.dp)
                                            .background(zRedColor.copy(alpha = 0.1f))
                                            .height(20.dp)
                                            .clip(RoundedCornerShape(5.dp))
                                            .border(BorderStroke(0.5.dp, zRedColor)),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "See items",
                                            fontSize = Dimens.FontSize1,
                                            color = zRedColor,
                                            modifier = Modifier,
                                            fontWeight = FontWeight.Normal
                                        )
                                        Icon(
                                            imageVector = Icons.Default.PlayArrow,
                                            contentDescription = "Add",
                                            tint = zRedColor,
                                            modifier = Modifier
                                                .size(16.dp)
                                                .padding(top = 5.dp, end = 5.dp)
                                        )
                                    }



                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }
            }
        }
}

