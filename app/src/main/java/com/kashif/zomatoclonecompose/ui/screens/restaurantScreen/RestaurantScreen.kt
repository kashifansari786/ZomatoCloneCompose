package com.yugesh.zomatoclone.screens.restaurantScreen

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.screens.homeScreen.components.HomeScreenFilterItemRow
import com.kashif.zomatoclonecompose.screens.homeScreen.components.getAllRestaurantFilterItems
import com.kashif.zomatoclonecompose.screens.restaurantScreen.components.RestaurantScreenCategoryDropDown
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.CollapsedRestaurantTopBar
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.MostOrderItems
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.OfferSliders
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.RestaurantBottomBar
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.RestaurantOrderList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components.YourOrderItems
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.addList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.barbequeList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.biryaniList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.bottomList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.breadsList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.dessertsList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.mainList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.matchedList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.mostItemList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.recomemdedList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.roolsList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.specialList
import com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.model.yourOrderList
import com.kashif.zomatoclonecompose.ui.theme.zBackgroundColor
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zDarkGray
import com.kashif.zomatoclonecompose.ui.theme.zGreenRatingColor
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zLightGreyBorder
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import com.kashif.zomatoclonecompose.ui.utils.DottedDivider
import com.kashif.zomatoclonecompose.ui.utils.TextWithIcon
import kotlinx.coroutines.launch

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RestaurantScreen(

) {

    //category selected at the bottom bar or from list
    var selectedCategoryIndex by remember { mutableStateOf(0) }
    val listState = rememberLazyListState()
    val _bottomList = remember { bottomList.toMutableStateList() }
    val coroutineScope = rememberCoroutineScope()

//    val overlapHeightPx = with(LocalDensity.current) {
//        Dimens.COLLAPSED_TOP_BAR_HEIGHT.toPx()
//    }
    var isCollapsed by remember { mutableStateOf(false) }
    // Synchronize selected category with list scroll position
    LaunchedEffect(listState) {

        snapshotFlow { listState.firstVisibleItemIndex }
            .collect { index ->
                selectedCategoryIndex = index
                _bottomList.forEach { it.selected = false }
                _bottomList[index].selected = true
            }
    }
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex > 0 }
            .collect { index ->
                isCollapsed = index
            }
    }

//    val scrollState = rememberLazyListState()

//
//    LaunchedEffect(scrollState.layoutInfo.totalItemsCount) {
//        isCollapsed = scrollState.layoutInfo.visibleItemsInfo.isNotEmpty()
//    }
    setBarColorsRes()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = zBackgroundColor,
        bottomBar = {
            RestaurantBottomBar(
                bottomList = _bottomList,
                selectedIndex = selectedCategoryIndex,
                onOptionClicked = { selected ->
                    _bottomList.forEach { it.selected = false }
                    _bottomList.find { it.title == selected.title }?.selected = true
                    selectedCategoryIndex = _bottomList.indexOf(selected)
                    coroutineScope.launch {
                        listState.animateScrollToItem(selectedCategoryIndex)
                    }
                }
            )
        },
//        floatingActionButton = { RestaurantScreenFAB() },
//        floatingActionButtonPosition = FabPosition.Center,
        topBar = {
            TopAppBar(
               modifier = Modifier
                   .statusBarsPadding()
                   .padding(WindowInsets.statusBars.asPaddingValues()),
                elevation = 8.dp,
                backgroundColor = Color.White
            ) {
                val modifier = Modifier
                    .fillMaxWidth()
                    // .zIndex(1f)
                    .background(color = Color.Transparent)
                CollapsedRestaurantTopBar(modifier,isCollapsed=isCollapsed)
            }
        }
    ) {
        val nestedScrollConnection = remember {
            object : NestedScrollConnection {}
        }
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(nestedScrollConnection),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center, modifier = Modifier.background(zWhite)) {
                    Text(
                        text = "Tunday Kababi",
                        fontSize = Dimens.FontSize9,
                        fontWeight = FontWeight.Bold,
                        color = zBlack,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Mughlai . Kebab . Biryani",
                        fontSize = Dimens.FontSize3,
                        fontWeight = FontWeight.Normal,
                        color = zDarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(zGreenRatingColor, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 4.dp, vertical = 4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                            ) {
                                Text(
                                    text = "4.2",
                                    fontSize = Dimens.FontSize3, // Use Dimens.FontSize5 if defined
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Icon(
                                    painter = painterResource(R.drawable.star), // Replace with your icon resource
                                    contentDescription = null, // Optional padding
                                    modifier = Modifier
                                        .padding(start = 3.dp)
                                        .size(11.dp),
                                    tint = zWhite // Ensure original icon colors are used
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.width(100.dp)
                        ) {
                            Text(
                                text = "19.4k ratings",
                                fontSize = Dimens.FontSize3, // Use Dimens.FontSize5 if defined
                                fontWeight = FontWeight.Normal,
                                color = zBlack
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            DottedDivider()
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .background(
                                zLightGreyBorder,
                                shape = RoundedCornerShape(Dimens.ShimmerBoxHeight)
                            )
                            .border(
                                Dimens.Border,
                                zLightGray,
                                RoundedCornerShape(Dimens.ShimmerBoxHeight)
                            )
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(3.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.fortyfive_min),
                                contentDescription = "time",
                                modifier = Modifier.size(20.dp),
                                tint = Color.Unspecified
                            )
                            Text(
                                text = "18 mins . 1 km",
                                fontSize = Dimens.FontSize3,
                                fontWeight = FontWeight.Normal,
                                color = zBlack,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Divider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(10.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            TextWithIcon(
                                text = "Parade",
                                leadingIcon = null,
                                trailingIcon = Icons.Default.KeyboardArrowDown
                            )
                        }
                    }
                    // slider delivery and other offers
                    OfferSliders()
                    HomeScreenFilterItemRow(categories = getAllRestaurantFilterItems())
                }




            }
            // LazyColumn for bottom list
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  YourOrderItems(yourOrderList) },
                    categoryName = bottomList[0].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  MostOrderItems(mostItemList) },
                    categoryName = bottomList[1].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(recomemdedList) },
                    categoryName = bottomList[2].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(matchedList) },
                    categoryName = bottomList[3].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(specialList) },
                    categoryName = bottomList[4].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(barbequeList) },
                    categoryName = bottomList[5].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(mainList) },
                    categoryName = bottomList[6].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(biryaniList) },
                    categoryName = bottomList[7].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(roolsList) },
                    categoryName = bottomList[8].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(breadsList) },
                    categoryName = bottomList[9].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(addList) },
                    categoryName = bottomList[10].title
                )
            }
            item {
                RestaurantScreenCategoryDropDown(
                    content = {  RestaurantOrderList(dessertsList) },
                    categoryName = bottomList[11].title
                )
            }


//            items(bottomList) {items->
//                //your order
//                RestaurantScreenCategoryDropDown(
//                    content = { DropDownList() },
//                    categoryName = items.title
//                )
//            }
        }

    }
}
@Composable
private fun setBarColorsRes() {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController) {
        systemUiController.setNavigationBarColor(color = Color.Black, darkIcons = true)
        systemUiController.setStatusBarColor(color = Color.White, darkIcons = true)
        onDispose { }
    }
}


@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {
  //  val navHostController:NavHostController= rememberNavController()
   // val scrollState = rememberScrollState()
    val modifier= Modifier
        .zIndex(1f)
        .background(color = Color.Transparent)
    RestaurantScreen()
    //AllRestaurantsList()
    // HomeScreen(navHostController, isCollapsed)
}
