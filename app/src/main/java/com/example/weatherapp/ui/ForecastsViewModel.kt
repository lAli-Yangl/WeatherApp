package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Forecasts
import com.example.weatherapp.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastsViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _forecasts = Channel<Forecasts> {}

    public val forecastsTemps: Flow<Forecasts> = _forecasts.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecastsTemps = api.getForecastTemperatures("55444")
        _forecasts.trySend(forecastsTemps)

    }
}