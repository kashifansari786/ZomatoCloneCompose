package com.kashif.zomatoclonecompose.screens.loginScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.R
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.screens.loginScreen.components.countryCodePicker.SelectCountryWithCountryCode
import com.kashif.zomatoclonecompose.ui.theme.zSkipButtonBgColor
import com.kashif.zomatoclonecompose.ui.theme.zWhite
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
@Composable
fun LoginForm(
    navHostController: NavHostController
) {

    val skipButtonFontSize = 12.sp
    val skipButtonAlpha = 0.8f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(contentAlignment = Alignment.TopEnd,modifier = Modifier
            .fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.login_page_top_image),
                contentDescription = "Login Page Top Image",
            )

            Button(
                onClick = { navHostController.navigate(Route.ZomatoNavigator.route) },
                modifier = Modifier
                    .padding(top = 300.dp)
                    .alpha(skipButtonAlpha)
                    .blur(90.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = zSkipButtonBgColor)
            ) {
                Text(
                    text = stringResource(R.string.skip_button_text),
                    fontSize = skipButtonFontSize,
                    modifier = Modifier.alpha(skipButtonAlpha),
                    color = zWhite
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadingText(
                text = stringResource(R.string.login_page_top_heading_one)
            )
            HeadingText(
                text = stringResource(R.string.login_page_top_heading_two)
            )

            LoginTextDivider(R.string.login_or_signup)

            SelectCountryWithCountryCode(navHostController=navHostController)

            Button(
                onClick = { navHostController.navigate(Route.ZomatoNavigationGraph.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.continue_button_text),
                    modifier = Modifier.padding(6.dp),
                    color = Color.White
                )
            }

            OrTextDivider(R.string.or_divider_text)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RoundButton(
                    text = stringResource(R.string.google_logo),
                    image = painterResource(id = R.drawable.google_logo)
                ) {
                    /*TODO*/
                }
                RoundButton(
                    text = stringResource(R.string.three_dots_logo),
                    image = painterResource(id = R.drawable.ic_three_dots)
                ) {
                    /*TODO*/
                }
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
private fun ExpandedTopBarPrevi() {
    val navHostController:NavHostController= rememberNavController()
//    val scrollState = rememberLazyListState()
//    HomeScreen(navHostController,scrollState)
    LoginForm(navHostController = navHostController)
    // HomeScreen(navHostController, isCollapsed)
}
