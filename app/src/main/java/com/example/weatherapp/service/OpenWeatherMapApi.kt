package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.Forecasts
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "d91797be752bdc1ac77680daee3dc9c4",
        @Query("units") unit: String = "imperial"
    ): CurrentConditions

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "d91797be752bdc1ac77680daee3dc9c4",
        @Query("units") unit: String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastTemperatures(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "d91797be752bdc1ac77680daee3dc9c4",
        @Query("units") unit: String = "imperial"
    ): Forecasts

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastTemperatures(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "d91797be752bdc1ac77680daee3dc9c4",
        @Query("units") unit: String = "imperial"
    ) : Forecasts


}

