package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.LatitudeLongitude


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    latitudeLongitude: LatitudeLongitude?,
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit
) {
    val state by viewModel.currentConditions.collectAsState(initial = null)

    if (latitudeLongitude != null) {
        LaunchedEffect(Unit) {
            viewModel.fetchCurrentLocationData(latitudeLongitude)
        }
    } else {
        LaunchedEffect(Unit){
            viewModel.fetchData()
        }
    }

    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name)) }
    ) {
        state?.let {
            CurrentConditionsContent(it, onGetWeatherForMyLocationClick, onForecastButtonClick)
        }
    }
}


@Composable
private fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onGetWeatherForMyLocationClick: () -> Unit,
    onForecastButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = currentConditions.cityName,
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.temperature, currentConditions.conditions.temperature.toInt()),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 70.sp,
                    )
                )

                Text(
                    text = stringResource(id = R.string.feels_like, currentConditions.conditions.feelslike.toInt()),
                    style = TextStyle(
                        fontSize = 12.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))

            val iconUrl = String.format(String.format(
                "https://openweathermap.org/img/wn/%s@2x.png",
                currentConditions.weatherData.firstOrNull()?.iconName
            ))
            AsyncImage(
                model = iconUrl,
                contentDescription = "null",
                modifier = Modifier.size(100.dp),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            val textStyle = TextStyle(
                fontSize = 16.sp,
            )
            Text(text = stringResource(id = R.string.low, currentConditions.conditions.minTemperature.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.high, currentConditions.conditions.maxTemperature.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.humidity, currentConditions.conditions.humidity.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.pressure, currentConditions.conditions.pressure.toInt()), style = textStyle)

        }

        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))

        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onGetWeatherForMyLocationClick) {
            Text(text = stringResource(id = R.string.get_my_weather_for_my_location))

        }

    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun CurrentConditionsScreenPreview() {
}