package com.example.weatherapp.ui
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.ForecastsData
import com.example.weatherapp.models.LatitudeLongitude
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonth


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    latitudeLongitude: LatitudeLongitude?,
    viewModel: ForecastsViewModel = hiltViewModel(),
) {
    val state by viewModel.forecastsTemps.collectAsState(initial = null)

    if(latitudeLongitude != null){
        LaunchedEffect(Unit){
            viewModel.fetchCurrentLocationData(latitudeLongitude)
        }
    } else {
        viewModel.fetchData()
    }


    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name)) }
    ) {
        state?.let {
            LazyColumn {
                items(items = it.DailyForecastData) { item: ForecastsData ->
                    ForecastRow(item = item)
                }
            }
        }
    }
}

@Composable
private fun ForecastRow(item:ForecastsData) {
    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val textStyle = TextStyle(
            fontSize = 13.sp,
        )
        val iconUrl = String.format(String.format(
            "https://openweathermap.org/img/wn/%s@2x.png",
            item.weatherIconImage.firstOrNull()?.iconName
        ))
        AsyncImage(
            model = iconUrl,
            contentDescription = "null",
            modifier = Modifier.size(100.dp),
        )
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
                 text = stringResource(id = R.string.high, item.temperatures.maxTemperature.toInt()),
                style = textStyle
            )
            Text(
                text = stringResource(id = R.string.low,  item.temperatures.minTemperature.toInt()),
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
//
//@Preview(
//    "ForecastTempFragment",
//    device = Devices.PIXEL_4,
//    showBackground = true,
//    showSystemUi = true,
//)
//@Composable
//private fun ForecastRowPreview() {
//    ForecastRow(item = forecastData[0])
//}