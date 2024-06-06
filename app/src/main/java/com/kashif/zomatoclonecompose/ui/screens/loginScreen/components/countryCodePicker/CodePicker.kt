package com.kashif.zomatoclonecompose.screens.loginScreen.components.countryCodePicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun CodeDialog(
    navigator: NavHostController,
    modifier: Modifier = Modifier,
    padding: Dp = 15.dp,
    defaultSelectedCountry: CountryData = getLibCountries().first(),
    showCountryCode: Boolean = true,
    pickedCountry: (CountryData) -> Unit
) {
    val countryList: List<CountryData> = getLibCountries()
    var isPickCountry by remember { mutableStateOf(defaultSelectedCountry) }
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(padding)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                navigator.navigate(Route.CountryPickerScreen.route)
            },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier.width(24.dp),
                painter = painterResource(
                    id = getFlags(
                        isPickCountry.countryCode
                    )
                ), contentDescription = null
            )
            if (showCountryCode) {
                Text(
                    text = isPickCountry.countryPhoneCode,
                    fontWeight = FontWeight.Bold,
                    fontSize = Dimens.FontSize2,
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}
