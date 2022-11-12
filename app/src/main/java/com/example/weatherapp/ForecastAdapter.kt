package com.example.weatherapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R.id
import com.example.weatherapp.R.layout
import com.example.weatherapp.models.DayForecast

class ForecastAdapter(private val data: List<DayForecast>) :
    RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val forecastDate: TextView
    private val forecastTemp: TextView
    private val forecastHigh: TextView
    private val forecastLow: TextView
    private val forecastSunrise: TextView
    private val forecastSunset: TextView


    init {
        forecastDate = view.findViewById(id.forecast_Date)
        forecastTemp = view.findViewById(id.temperature)
        forecastHigh = view.findViewById(id.max_temp)
        forecastLow = view.findViewById(id.min_temp)
        forecastSunrise = view.findViewById(id.sunrise)
        forecastSunset = view.findViewById(id.sunset)

    }


    fun bind(data: DayForecast) {
        forecastDate.text = data.getDate()
        forecastTemp.text = data.forecastTemp.getMin()
        forecastHigh.text = data.forecastTemp.getMax()
        forecastLow.text = data.forecastTemp.getMin()
        forecastSunrise.text = data.getSunriseTime()
        forecastSunset.text = data.getSunsetTime()
    }
}
