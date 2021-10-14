package com.gsrocks.gsweather.repository

import com.gsrocks.gsweather.api.RetrofitInstance

class WeatherRepository {
    suspend fun getCurrentWeather(city: String) =
        RetrofitInstance.api.getCurrentWeather(queryData = city)
}