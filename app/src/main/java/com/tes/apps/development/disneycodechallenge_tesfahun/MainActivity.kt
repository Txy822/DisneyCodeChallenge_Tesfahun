package com.tes.apps.development.disneycodechallenge_tesfahun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tes.apps.development.disneycodechallenge_tesfahun.presentation.LoginScreen
import com.tes.apps.development.disneycodechallenge_tesfahun.presentation.SelectGuestScreen
import com.tes.apps.development.disneycodechallenge_tesfahun.ui.theme.DisneyCodeChallenge_TesfahunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisneyCodeChallenge_TesfahunTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    GuestsListProvider()
                }
            }
        }
    }

    @Composable
    fun GuestsListProvider(){
        val navController = rememberNavController()

        SelectGuestScreen(navController=navController, continueButton = {})

    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        DisneyCodeChallenge_TesfahunTheme {
            Greeting("Android")
        }
    }
}