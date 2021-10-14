package com.gsrocks.gsweather.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gsrocks.gsweather.repository.WeatherRepository

class WeatherViewModelProviderFactory(
    val weatherRepository: WeatherRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepository) as T
    }
}