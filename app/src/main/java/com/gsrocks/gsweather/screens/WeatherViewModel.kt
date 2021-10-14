package com.gsrocks.gsweather.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gsrocks.gsweather.models.CurrentWeatherResponse
import com.gsrocks.gsweather.repository.WeatherRepository
import com.gsrocks.gsweather.utils.DataState
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel(
    val weatherRepository: WeatherRepository
) : ViewModel() {
    val currentWeather: MutableLiveData<DataState<CurrentWeatherResponse>> = MutableLiveData()

    fun getCurrentWeather(city: String) = viewModelScope.launch {
        currentWeather.postValue(DataState.Loading())
        val response = weatherRepository.getCurrentWeather(city)
        currentWeather.postValue(handleCurrentWeatherResponse(response))
    }

    fun handleCurrentWeatherResponse(response: Response<CurrentWeatherResponse>): DataState<CurrentWeatherResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return DataState.Success(it)
            }
        }
        return DataState.Failure(response.message())
    }
}