package com.kashif.zomatoclonecompose.ui.screens.restaurantScreen.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 03,June,2024
 */

@Composable
fun CollapsedRestaurantTopBar(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean
) {
    val color: Color by animateColorAsState(Color.Transparent)
    val height: Dp by animateDpAsState(if (isCollapsed) 60.dp else 150.dp)
    val searchState = rememberSaveable { mutableStateOf("") }
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = searchState.value)) }
    val textFieldValue = textFieldValueState.copy(text = searchState.value)
    val keyboardController = LocalTextInputService.current

    Box(
        modifier = modifier
            .background(color)
            .height(height),
           // .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "backarrow",
                modifier = Modifier.size(30.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                if (!isCollapsed) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = "search",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.heart_empty),
                            contentDescription = "heart",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.share_icon),
                            contentDescription = "share",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.more_icon),
                            contentDescription = "more",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                } else {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                            .height(40.dp)
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(Dimens.CornerShape)
                            )
                            .border(
                                Dimens.Border,
                                Color.LightGray,
                                RoundedCornerShape(Dimens.CornerShape)
                            ),
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValueState = it
                            if (searchState.value != it.text) {
                                // onValueChange(it.text)
                            }
                        },
                        singleLine = true,
                        placeholder = {
                            Text(
                                text = "Search in Tunday Kababi",
                                color = Color.Black,
                                fontSize = Dimens.FontSize1,
                                fontWeight = FontWeight.Medium
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            autoCorrect = true,
                        ),
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hideSoftwareKeyboard() }),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = Color.DarkGray,
                            textColor = Color.Black
                        ),
                        leadingIcon = {
                            IconButton(onClick = { /* Handle mic button click */ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = zRedColor
                                )
                            }
                        },
                        shape = RoundedCornerShape(Dimens.CornerShape),
                        textStyle = TextStyle(fontSize = Dimens.FontSize1, fontWeight = FontWeight.Medium),
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = false)
//@Composable
//private fun ExpandedTopBarPreview() {
//    val navHostController:NavHostController= rememberNavController()
//   // val scrollState = rememberScrollState()
//    val modifier= Modifier
//        .zIndex(1f)
//        .background(color = Color.Transparent)
//    CollapsedRestaurantTopBar(navHostController,modifier,true)
//    //AllRestaurantsList()
//    // HomeScreen(navHostController, isCollapsed)
//}