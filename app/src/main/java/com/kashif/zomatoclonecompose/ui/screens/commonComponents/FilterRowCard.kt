package com.kashif.zomatoclonecompose.screens.commonComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.ui.theme.zBlack
import com.kashif.zomatoclonecompose.ui.theme.zLightGray
import com.kashif.zomatoclonecompose.ui.theme.zRedColor
import com.kashif.zomatoclonecompose.ui.theme.zSelectedFilterRowItemBg
import com.kashif.zomatoclonecompose.ui.theme.zWhite
import com.kashif.zomatoclonecompose.ui.utils.Dimens

/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterRowCard(
    text: String,
    leadingIcon: Int? = null,
    trailingIcon: ImageVector? = null,
    leadingIconContentDescription: String? = "",
    trailingIconContentDescription: String? = ""
) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        border = if (isSelected) {
            BorderStroke(0.5.dp, zRedColor)
        } else {
            BorderStroke(0.5.dp, zLightGray)
        },
        onClick = { isSelected = !isSelected },
        backgroundColor = if (isSelected) {
            zSelectedFilterRowItemBg
        } else {
            zWhite
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            if (leadingIcon != null) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = leadingIconContentDescription,
                    tint = Color.Unspecified, modifier = Modifier.size(20.dp)
                )
            }
            Text(text = text, fontSize = Dimens.FontSize2, color = zBlack, modifier = Modifier.padding(6.dp))
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = trailingIconContentDescription,
                    tint = zBlack
                )
            }
        }
    }
}
