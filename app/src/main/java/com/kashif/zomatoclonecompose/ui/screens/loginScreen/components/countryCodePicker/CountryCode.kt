package com.kashif.zomatoclonecompose.screens.loginScreen.components.countryCodePicker

import com.kashif.zomatoclonecompose.R
import java.util.Locale
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
data class CountryData(
    private var cCodes: String,
    val countryPhoneCode: String = "+91",
    val cNames: String = "in",
    val flagResID: Int = R.drawable.`in`
) {
    val countryCode = cCodes.lowercase(Locale.getDefault())
}
