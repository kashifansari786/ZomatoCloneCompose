package com.kashif.zomatoclonecompose.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kashif.zomatoclonecompose.screens.commonComponents.FilterRowCard
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun HomeScreenFilterItemRow(
    categories: List<FilterRowItems>,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        val scrollState = rememberLazyListState()
        LazyRow(
            modifier = Modifier
                .background(Color.White)
                .padding(start = 10.dp),
            state = scrollState
        ) {
            items(categories) { category ->
                FilterRowCard(
                    text = category.text,
                    leadingIcon = category.leadingIcon,
                    trailingIcon = category.trailingIcon
                )
            }
        }
    }
}