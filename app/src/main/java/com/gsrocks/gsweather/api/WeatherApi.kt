package com.gsrocks.gsweather.api

import com.gsrocks.gsweather.models.CurrentWeatherResponse
import com.gsrocks.gsweather.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q")
        queryData: String,
        @Query("key")
        apiKey: String = API_KEY
    ): Response<CurrentWeatherResponse>
}