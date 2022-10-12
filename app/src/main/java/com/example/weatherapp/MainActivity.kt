package com.example.weatherapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.databinding.FragmentCurrentConditionsBinding
import com.example.weatherapp.ui.CurrentConditionsScreen
import com.example.weatherapp.ui.ForecastScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    @Inject lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: FragmentCurrentConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditionsFragment") {
                composable("CurrentConditionsFragment") {
                    CurrentConditionsScreen {
                        navController.navigate("Forecast")
                    }
                }
                composable("Forecast"){
                    ForecastScreen()
                }

            }
        }
    }

}