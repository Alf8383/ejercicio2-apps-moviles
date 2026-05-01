package com.aless.ejercicio2appsmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aless.ejercicio2appsmoviles.ui.theme.Ejercicio2AppsMovilesTheme

@Composable
fun MainScreen(
    onGoHome: () -> Unit,
    onGoForm: () -> Unit,
    onGoInventory: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla principal",
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            onClick = onGoHome,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Ir a Home")
        }
        Button(
            onClick = onGoForm,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Ir a Formulario")
        }
        Button(
            onClick = onGoInventory,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Ir a Inventario")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    Ejercicio2AppsMovilesTheme {
        MainScreen(
            onGoHome = {},
            onGoForm = {},
            onGoInventory = {}
        )
    }
}

