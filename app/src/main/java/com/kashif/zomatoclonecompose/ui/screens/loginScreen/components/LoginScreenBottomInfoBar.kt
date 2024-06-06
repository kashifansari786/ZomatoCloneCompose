package com.kashif.zomatoclonecompose.screens.loginScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif.zomatoclonecompose.R
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun LoginScreenBottomInfoBar() {
    val fontSize = 11.sp
    val fontColor: Color = Color.Black

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 26.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.by_continuing_you_agree_to_our),
            color = fontColor,
            fontSize = fontSize
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            UnderlinedText(text = stringResource(R.string.terms_of_service), onClick = {})
            UnderlinedText(text = stringResource(R.string.privacy_policy), onClick = {})
            UnderlinedText(text = stringResource(R.string.content_policy), onClick = {})
        }
    }
}
