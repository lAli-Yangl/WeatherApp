package com.example.weatherapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


val forecastTemperature1 = ForecastTemp(42.0f, 61.0f, 58.2f)
val forecastTemperature2 = ForecastTemp(50.0f, 69.0f, 65.2f)
val forecastTemperature3 = ForecastTemp(51.0f, 73.0f, 60.25f)
val forecastTemperature4 = ForecastTemp(49.5f, 71.7f, 70.1f)
val forecastTemperature5 = ForecastTemp(50.3f, 79.2f, 80.3f)
val forecastTemperature6 = ForecastTemp(72.4f, 99.1f, 90.5f)
val forecastTemperature7 = ForecastTemp(70.4f, 99.0f, 80.4f)
val forecastTemperature8 = ForecastTemp(69.5f, 80.1f, 75.1f)
val forecastTemperature9 = ForecastTemp(65.5f, 90.5f, 79.4f)
val forecastTemperature10 = ForecastTemp(50.4f, 80f, 73.4f)
val forecastTemperature11 = ForecastTemp(32.1f, 85.4f, 73.9f)
val forecastTemperature12 = ForecastTemp(0.0f, 80.4f, 32.4f)
val forecastTemperature13 = ForecastTemp(10.5f, 55.7f, 40.5f)
val forecastTemperature14 = ForecastTemp(23.1f, 100.5f, 40.5f)
val forecastTemperature15 = ForecastTemp(43.0f, 109.5f, 99.5f)
val forecastTemperature16 = ForecastTemp(90.6f, 115.5f, 111.5f)

val forecastData: List<DayForecast> = listOf<DayForecast>(
    DayForecast(1664648040L, 1664622000L, 1664672400L, forecastTemperature1, 3.5f, 100),
    DayForecast(1664709000L, 1664709000L, 1664758500L, forecastTemperature2, 9.3f, 59),
    DayForecast(1664773200L, 1664796000L, 1664844600L, forecastTemperature3, 4.5f, 69),
    DayForecast(1664859600L, 1664883000L, 1664930700L, forecastTemperature4, 9.0f, 22),
    DayForecast(1664946000L, 1664970000L, 1665016800L, forecastTemperature5, 10.0f, 1),
    DayForecast(1665032400L, 1665057000L, 1665102900L, forecastTemperature6, 20.3f, 14),
    DayForecast(1665118800L, 1665144000L, 1665189000L, forecastTemperature7, 2.4f, 33),
    DayForecast(1665205200L, 1665231000L, 1665275100L, forecastTemperature8, 33.2f, 25),
    DayForecast(1665291600L, 1665318000L, 1665361200L, forecastTemperature9, 43.2f, 10),
    DayForecast(1665378000L, 1665405000L, 1665447300L, forecastTemperature10, 30.2f, 9),
    DayForecast(1665464400L, 1665492000L, 1665533700L, forecastTemperature11, 2.9f, 13),
    DayForecast(1665550800L, 1665579000L, 1665619500L, forecastTemperature12, 11.9f, 78),
    DayForecast(1665637200L, 1665666600L, 1665705900L, forecastTemperature13, 99.2f, 92),
    DayForecast(1665723600L, 1665753600L, 1665791700L, forecastTemperature14, 21.2f, 88),
    DayForecast(1665810000L, 1665840600L, 1665877800L, forecastTemperature15, 30.2f, 43),
    DayForecast(1665896400L, 1665927600L, 1665963900L, forecastTemperature16, 69.9f, 1)
)


class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)

    }
}
