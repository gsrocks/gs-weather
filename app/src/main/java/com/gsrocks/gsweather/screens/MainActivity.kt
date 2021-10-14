package com.gsrocks.gsweather.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gsrocks.gsweather.R
import com.gsrocks.gsweather.databinding.ActivityMainBinding
import com.gsrocks.gsweather.repository.WeatherRepository
import com.gsrocks.gsweather.utils.DataState

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel
    lateinit var bindinng: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindinng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindinng.root)

        val weatherRepository = WeatherRepository()
        val weatherViewModelProviderFactory = WeatherViewModelProviderFactory(weatherRepository)
        viewModel = ViewModelProvider(
            this,
            weatherViewModelProviderFactory
        ).get(WeatherViewModel::class.java)

        bindinng.btnLoad.setOnClickListener {
            viewModel.getCurrentWeather("London")
        }

        viewModel.currentWeather.observe(this, Observer {
            when (it) {
                is DataState.Success -> Log.d("GSW", "Success ${it.data}")
                is DataState.Loading -> Log.d("GSW", "Loading")
                is DataState.Failure -> Log.d("GSW", "Failure ${it.message}")
            }
        })
    }
}