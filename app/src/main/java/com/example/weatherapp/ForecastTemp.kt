package com.example.weatherapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastTemp(
    val min: Float,
    val max: Float,
    val current: Float,
) : Parcelable {

    fun getMin() : String{
        return "Low: ${min.toInt()}°"
    }


    fun getMax() : String{
        return "High: ${max.toInt()}°"
    }


    fun getCurrent() : String{
        return "Temp: ${current.toInt()}°"
    }
}
