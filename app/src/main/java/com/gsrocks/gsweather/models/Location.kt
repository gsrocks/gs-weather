package com.gsrocks.gsweather.models

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tzId: String,
    val localtimeEpoch: Int,
    val localTime: String
)
