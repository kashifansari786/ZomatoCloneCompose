package com.kashif.zomatoclonecompose.ui.screens.LocationScreen.model

/**
 * Created by Mohammad Kashif Ansari on 01,June,2024
 */
data class LocationModel(
    val name:String,
    val address:String,
    val distance:String
)

val locationList= listOf(
    LocationModel(name = "Hotel Mahadeva Regency",
        address = "PPN college,PPN Market,Chauraha,Parade,Kanpur",
        distance = "215 m"),
    LocationModel(name = "Ursula Hospital Campus",
        address = "Meston Road,Shiwala,Parade,Kanpur",
        distance = "552 m"),
    LocationModel(name = "The Landmark Towers",
        address = "Civil Lines,Kanpur",
        distance = "439 m")
)
