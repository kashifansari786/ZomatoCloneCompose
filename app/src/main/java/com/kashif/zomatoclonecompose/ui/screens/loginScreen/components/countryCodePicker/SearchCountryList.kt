package com.kashif.zomatoclonecompose.screens.loginScreen.components.countryCodePicker

import android.content.Context
/**
 * Created by Mohammad Kashif Ansari on 26,May,2024
 */
fun List<CountryData>.searchCountry(key: String, context: Context): MutableList<CountryData> {
    val tempList = mutableListOf<CountryData>()
    this.forEach {
        if (context.resources.getString(getCountryName(it.countryCode)).lowercase()
                .contains(key.lowercase())
        ) {
            tempList.add(it)
        }
    }
    return tempList
}
