package com.kashif.zomatoclonecompose.ui.screens.homeScreen.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.utils.BottomShadow
import com.kashif.zomatoclonecompose.ui.utils.Dimens.Border
import com.kashif.zomatoclonecompose.ui.utils.Dimens.COLLAPSED_TOP_BAR_HEIGHT
import com.kashif.zomatoclonecompose.ui.utils.Dimens.CornerShape
import com.kashif.zomatoclonecompose.ui.utils.Dimens.Elevation
import com.kashif.zomatoclonecompose.ui.utils.Dimens.ExtraSmallPadding
import com.kashif.zomatoclonecompose.ui.utils.Dimens.FontSize1
import com.kashif.zomatoclonecompose.ui.utils.Dimens.FontSize2
import com.kashif.zomatoclonecompose.ui.utils.Dimens.FontSize3
import com.kashif.zomatoclonecompose.ui.utils.Dimens.MediumPadding24
import com.kashif.zomatoclonecompose.ui.utils.Dimens.Padding1
import com.kashif.zomatoclonecompose.ui.utils.Dimens.Padding2
import kotlinx.coroutines.delay

/**
 * Created by Mohammad Kashif Ansari on 29,May,2024
 */
data class SearchModel(val title:String)
@Composable
fun SearchBarWithSwitch() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = Elevation, end = Elevation),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .weight(4.5f)
            .padding(end = ExtraSmallPadding)
             ){
            SearchBar()

        }
        Box(
            modifier = Modifier.weight(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "VEG", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = FontSize3)
                Text(text = "ONLY", fontWeight = FontWeight.SemiBold,color = Color.Black, fontSize = FontSize1)
                VegOnlySwitch()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun SearchBar() {
    val searchState = rememberSaveable { mutableStateOf("") }
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = searchState.value)) }
    val textFieldValue = textFieldValueState.copy(text = searchState.value)
    val keyboardController = LocalTextInputService.current

    val searchHint = listOf(
        SearchModel("Search \"thali\""),
        SearchModel("Search \"paneer\""),
        SearchModel("Search \"burger\""),
        SearchModel("Search \"cake\""),
        SearchModel("Search \"curries\""),
        SearchModel("Search \"paratha\""),
        SearchModel("Search \"bread\""),
        SearchModel("Search \"chaat\""),
        SearchModel("Search \"rolls\""),
        SearchModel("Search \"chicken\""),
        SearchModel("Search \"dosa\""),
        SearchModel("Search \"chowmein\""),
        SearchModel("Search \"dal\""),
        SearchModel("Search \"sandwich\""),
        SearchModel("Search \"tandoori\""),
        SearchModel("Search \"naan\""),
        SearchModel("Search \"fries\""),
        SearchModel("Search \"pasta\""),
        SearchModel("Search \"pizza\""),
        SearchModel("Search \"biryani\""),

    )

    var currentIndex by remember { mutableStateOf(0) }

    // Launch coroutine to update the index every 3 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000L)
            currentIndex = (currentIndex + 1) % searchHint.size
        }
    }

    val currentOffer = searchHint[currentIndex]
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(CornerShape))
                .border(Border, Color.LightGray, RoundedCornerShape(CornerShape)),
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
                AnimatedContent(
                    targetState = currentOffer.title,
                    transitionSpec = {
                        (slideInVertically { it } + fadeIn() with slideOutVertically { -it } + fadeOut())
                            .using(SizeTransform(clip = false))
                    }
                ) { text ->
                    Text(
                        text = text,
                        color = Color.Black,
                        fontSize = FontSize3,
                        fontWeight = FontWeight.Medium
                    )
                }

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
            trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(MediumPadding24)
                            .width(Border)
                    )
                    IconButton(onClick = { /* Handle mic button click */ }) {
                        Icon(painter = painterResource(id = R.drawable.mic_png),modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .size(20.dp), contentDescription = "Mic", tint = zRedColor)
                    }
                }
            },
            leadingIcon = {
                IconButton(onClick = { /* Handle mic button click */ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = zRedColor)
                }
            }
        )
    }

//}

@Composable
fun VegOnlySwitch() {
    var isChecked by remember { mutableStateOf(false) }

    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Color.Green,
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBarWithSwitch() {
    SearchBarWithSwitch()
}