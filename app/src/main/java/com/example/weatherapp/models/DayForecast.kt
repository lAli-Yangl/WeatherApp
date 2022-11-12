package com.example.weatherapp.models

import android.os.Parcelable
import com.example.weatherapp.ForecastTemp
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Parcelize
data class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val forecastTemp: ForecastTemp,
    val pressure: Float,
    val humidity: Int,
) : Parcelable {

    private val dateTimestamp = this.date
    private val formatter = DateTimeFormatter.ofPattern("MMM dd")
    private val dateTime = LocalDateTime.ofEpochSecond(dateTimestamp, 0, ZoneOffset.of("-5"))
    private val formattedDate = formatter.format(dateTime)

    private val sunriseTimeStamp = this.sunrise
    private val sunriseTimeFormatter = DateTimeFormatter.ofPattern("h:mm")
    private val sunriseTime = LocalDateTime.ofEpochSecond(sunriseTimeStamp, 0, ZoneOffset.of("-5"))
    private val formattedSunrise = sunriseTimeFormatter.format(sunriseTime)

    private val sunsetTimeStamp = this.sunset
    private val sunsetTimeFormatter = DateTimeFormatter.ofPattern("h:mm")
    private val sunsetTime = LocalDateTime.ofEpochSecond((sunsetTimeStamp), 0, ZoneOffset.of("-5"))
    private val formattedSunset = sunsetTimeFormatter.format(sunsetTime)

    fun getDate(): String {
        return formattedDate
    }

    fun getSunriseTime(): String{
        return "Sunrise: $formattedSunrise am"
    }

    fun getSunsetTime(): String{
        return "Sunset: $formattedSunset pm"
    }

}