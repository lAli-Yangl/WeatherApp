package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun CurrentConditionsScreen(
    onForecastButtonClick: () -> Unit
){
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
            ){
        Text(
            text = stringResource(id = R.string.city_name),
            style =  TextStyle(
                fontWeight = FontWeight(600),
            fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier.padding(16.dp)
                ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = stringResource(id = R.string.current_temp),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 70.sp,
                    )
                )

                Text(text = stringResource(id = R.string.feels_like, 92),
                style = TextStyle(
                    fontSize = 12.sp,
                )
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.sun), contentDescription =  "Sunny")
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
            Text(text = stringResource(id = R.string.low, 20), style = textStyle)
            Text(text = stringResource(id = R.string.high, 120), style = textStyle)
            Text(text = stringResource(id = R.string.humidity, 23), style = textStyle)
            Text(text = stringResource(id = R.string.pressure, 1023), style = textStyle)

        }

        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))

        }

    }



}

@Preview(
    "CurrentConditionsFragment",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun CurrentConditionsScreenPreview(){
    CurrentConditionsScreen{}
}