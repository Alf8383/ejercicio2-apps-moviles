package com.aless.ejercicio2appsmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aless.ejercicio2appsmoviles.navigation.AppNavigation
import com.aless.ejercicio2appsmoviles.ui.theme.Ejercicio2AppsMovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio2AppsMovilesTheme {
                AppNavigation()
            }
        }
    }
}
