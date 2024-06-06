package com.kashif.zomatoclonecompose.screens.loginScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.R
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
private const val DividerAlpha = 0.25f
private val DividerThickness: Dp = 2.dp
private val dividerColor: Color = Color.LightGray

@Composable
fun LoginTextDivider(text:Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth(0.35f)
                .alpha(DividerAlpha)
                .padding(6.dp),
            color = dividerColor,
            thickness = DividerThickness
        )
        Text(
            text = stringResource(text),
            color = Color.DarkGray,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth(1f)
                .alpha(DividerAlpha)
                .padding(6.dp),
            color = dividerColor,
            thickness = DividerThickness
        )
    }
}

@Composable
fun OrTextDivider(text: Int) {
    Row(
       // horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .alpha(DividerAlpha),
            color = dividerColor,
            thickness = DividerThickness
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.wrapContentWidth(),
           // modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            text = stringResource(text),
            color = Color.DarkGray,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.width(8.dp))
        Divider(
            modifier = Modifier
                .weight(1f)
                .alpha(DividerAlpha),
            color = dividerColor,
            thickness = DividerThickness
        )
    }
}
