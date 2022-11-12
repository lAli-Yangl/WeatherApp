package com.example.weatherapp.ui
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ForecastTemp
import com.example.weatherapp.R
import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonth


val startDay = 1664648040L
val sunrise = 1664622000L
val sunset = 1664672400L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * (5 * 60 )),
        sunset = sunset - (it * (5 * 60)),
        forecastTemp = ForecastTemp(min = 70f + it, max = 80f + it),
        pressure = 1024f,
        humidity = 76
    )

}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen() {
    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name)) }
    ) {
        LazyColumn {
            items(items = forecastData) { item: DayForecast ->
                ForecastRow(item = item)
            }
        }
    }

}

@Composable
private fun ForecastRow(item: DayForecast) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val textStyle = TextStyle(
            fontSize = 13.sp,
        )
        Image(painter = painterResource(id = R.drawable.sun), contentDescription = "")
        Spacer(Modifier.weight(.01f, fill = true))
        Text(
            text = item.date.toMonth(),
            style = TextStyle(
                fontSize = 20.sp,
            )
        )
        Spacer(Modifier.weight(.02f, fill = true))
        Column {
            Text(
                text = stringResource(id = R.string.high, item.forecastTemp.max.toInt()),
                style = textStyle
            )
            Text(
                text = stringResource(id = R.string.low, item.forecastTemp.min.toInt()),
                style = textStyle
            )
        }
        Spacer(Modifier.weight(.05f, fill = true))
        Column (
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle
            )
        }
    }

}

@Preview(
    "ForecastTempFragment",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun ForecastRowPreview() {
    ForecastRow(item = forecastData[0])
}