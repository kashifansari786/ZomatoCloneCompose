package com.kashif.zomatoclonecompose.screens.loginScreen.components.countryCodePicker

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kashif.zomatoclonecompose.ui.screens.homeScreen.components.SearchBarWithSwitch
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun CountryCodePicker(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    showCountryCode: Boolean = true,
    defaultCountry: CountryData,
    navigator: NavHostController,
    pickedCountry: (CountryData) -> Unit
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = text)) }
    val textFieldValue = textFieldValueState.copy(text = text)
    val keyboardController = LocalTextInputService.current
    Surface(
        color = color
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 15.dp,end=15.dp, bottom = 10.dp)
            )
            {
                Box(  modifier = modifier
                    .wrapContentWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)) ){
                    Row {
                        Column {
                            navigator?.let {
                                CodeDialog(
                                    defaultSelectedCountry = defaultCountry,
                                    showCountryCode = showCountryCode,
                                    navigator = it,
                                    pickedCountry = pickedCountry
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(2.dp))
                OutlinedTextField(
                    modifier = modifier
                        .wrapContentWidth()
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)),
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValueState = it
                        if (text != it.text) {
                            onValueChange(it.text)
                        }
                    },
                    singleLine = true,
                    visualTransformation = PhoneNumberTransformation(defaultCountry.countryCode.uppercase()),
                    placeholder = {
                        Text(
                            text = "Enter Phone Number",
                            color = zLightGray,
                            fontSize = Dimens.FontSize3,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        autoCorrect = true,
                    ),
                    keyboardActions = KeyboardActions(onDone = { keyboardController?.hideSoftwareKeyboard() }),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.DarkGray,
                        textColor = Color.Black
                    ),

                )
            }
        }
    }
}

