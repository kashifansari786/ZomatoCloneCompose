package com.kashif.zomatoclonecompose.ui.screens.LocationScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.screens.loginScreen.components.OrTextDivider
import com.kashif.zomatoclonecompose.ui.screens.LocationScreen.model.locationList
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens
import com.kashif.zomatoclonecompose.ui.utils.Dimens.CornerShape
import com.kashif.zomatoclonecompose.ui.utils.Dimens.FontSize1
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.LocationOn
import com.kashif.zomatoclonecompose.ui.screens.LocationScreen.model.LocationModel
import com.kashif.zomatoclonecompose.ui.theme.zLightGray

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */

@Composable
fun LocationScreen() {
    val searchState = rememberSaveable { mutableStateOf("") }
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = searchState.value)) }
    val textFieldValue = textFieldValueState.copy(text = searchState.value)
    val keyboardController = LocalTextInputService.current


    Column(modifier = Modifier
        .fillMaxSize()
        .background(zWhite)
        .padding(top = 25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.bottom_arrow),
                contentDescription = "down arrow", modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Select a location",
                fontSize = Dimens.FontSize5,
                fontWeight = FontWeight.Bold,
                color = zBlack,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(50.dp)
                .background(Color.White, shape = RoundedCornerShape(Dimens.CornerShape))
                .border(Dimens.Border, Color.LightGray, RoundedCornerShape(Dimens.CornerShape)),
            value = textFieldValue,
            onValueChange = {
                textFieldValueState = it
                if (searchState.value != it.text) {
                    //onValueChange(it.text)
                }
            },
            singleLine = true,
            // visualTransformation = PhoneNumberTransformation(defaultCountry.countryCode.uppercase()),
            placeholder = {

                Text(
                    text = "Search for area, street name...",
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
            shape = RoundedCornerShape(CornerShape),
            textStyle = TextStyle(fontSize = FontSize1, fontWeight = FontWeight.Medium),
        )
        Box(
            modifier = Modifier
                .padding(10.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)

        ){
            Column(
                modifier = Modifier
                    .clickable { /* Handle click */ }

            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable { /* Handle click for Add address */ }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = zRedColor,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 30.dp),
                            text = "Add address",
                            color = zRedColor,
                            fontSize = Dimens.FontSize3,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                        contentDescription = "add",
                        tint = zBlack,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                }
                Divider(color = Color.Gray.copy(alpha = 0.2f), modifier = Modifier.padding(start = 5.dp, end = 5.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable { /* Handle click for Use your current location */ }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_gps_fixed_24),
                            contentDescription = "add",
                            tint = zRedColor,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(
                            modifier = Modifier.padding(start = 30.dp),
                            text = "Use your current location",
                            color = zRedColor,
                            fontSize = Dimens.FontSize3,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                        contentDescription = "add",
                        tint = zBlack,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        OrTextDivider(R.string.nearby_location)
        Box(
            modifier = Modifier
                .padding(10.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)

        ){
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ){
                LazyColumn {
                    items(locationList){item->
                        LocationList(item)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Icon(painter = painterResource(id = R.drawable.powered_google),
            contentDescription = "google", tint = Color.Unspecified, modifier = Modifier.size(width = 100.dp, height = 50.dp)
        )

    }
}

@Composable
fun LocationList(item: LocationModel) {
    Row (modifier = Modifier.padding(10.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "location",
                    tint = zBlack,
                )
                Text(
                    text = item.distance,
                    color = zBlack,
                    fontSize = Dimens.FontSize1,
                    fontWeight = FontWeight.Medium
                )
            }
            Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 10.dp)){
                Text(
                    text = item.name,
                    color = zBlack,
                    fontSize = Dimens.FontSize3,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.address,
                    color = zBlack,
                    fontSize = Dimens.FontSize2,
                    fontWeight = FontWeight.Normal
                )
            }

        }

    }
    Divider(modifier = Modifier.padding(start = 5.dp, end = 5.dp), color = zLightGray)

}

@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPreview() {

    LocationScreen()
    // ExploreLayout1()
    // HomeScreen(navHostController, isCollapsed)
}