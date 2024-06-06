package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.YourOrderModel
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.yourOrderList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zItemAddButtonBg
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 05,June,2024
 */
@Composable
fun YourOrderItems(yourOrderList: List<YourOrderModel>) {
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {}
    }
    val heigh=yourOrderList.size*90
    LazyColumn(modifier = Modifier.fillMaxWidth().height(heigh.dp).nestedScroll(nestedScrollConnection)) {
        items(yourOrderList){item->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp, start = 10.dp, end = 10.dp, bottom = 18.dp)
            ) {
                if (item.image.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .height(70.dp)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.image)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.placeholder_image),
                            error= painterResource(R.drawable.placeholder_image),
                            contentDescription = item.title,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(
                                    RoundedCornerShape(Dimens.Padding1)
                                )
                        )
                        Icon(painter = painterResource(id = if(item.type==0) R.drawable.veg_icon else R.drawable.non_veg_icon),
                            contentDescription = "icon", tint = Color.Unspecified, modifier = Modifier
                                .size(15.dp)
                                .padding(start = 5.dp, top = 5.dp)
                        )

                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center, modifier = Modifier.weight(1f)) {
                    Text(text = item.title,
                        fontSize = Dimens.FontSize3,
                        fontWeight = FontWeight.Bold,
                        color = zBlack,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = item.price,
                        fontSize = Dimens.FontSize2,
                        fontWeight = FontWeight.Bold,
                        color = zBlack
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = item.orderText,
                        fontSize = Dimens.FontSize1,
                        fontWeight = FontWeight.Bold,
                        color = zLightGray
                    )
                }
                Card(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(0.3f)
                        .height(25.dp),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(0.5.dp, zRedColor),
                    backgroundColor = zItemAddButtonBg
                ) {
                    Box(
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "ADD",
                                fontSize = Dimens.FontSize3,
                                color = zRedColor,
                                modifier = Modifier
                                    .padding(3.dp),
                                fontWeight = FontWeight.Normal
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = zRedColor,
                            modifier = Modifier
                                .size(16.dp)
                                .padding(top = 5.dp, end = 5.dp)
                        )
                    }
                }
            }
    }
    }

}

@Preview(showBackground = false)
@Composable
fun showOrder(){
    YourOrderItems(yourOrderList)
}
