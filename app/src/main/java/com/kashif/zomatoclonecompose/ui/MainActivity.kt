package com.kashif.zomatoclonecompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kashif.zomatoclonecompose.ui.theme.ZomatoCloneComposeTheme
import com.kashif.zomatoclonecompose.navgraph.NavGraph
import com.kashif.zomatoclonecompose.navgraph.Route
import com.kashif.zomatoclonecompose.screens.countryPicker.CountryPickerScreen
import com.kashif.zomatoclonecompose.screens.loginScreen.LoginScreen
import com.kashif.zomatoclonecompose.viewmodels.SplashScreenVm
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
class MainActivity : ComponentActivity() {

    private val viewModel: SplashScreenVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
        setContent {
            ZomatoCloneComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavGraph()
                }
            }
        }
    }
}
