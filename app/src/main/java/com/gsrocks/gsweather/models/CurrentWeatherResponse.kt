package com.gsrocks.gsweather.models

data class CurrentWeatherResponse(
    val location: Location,
    val current: Current,
    val status: String,
    val totalResults: Int
)