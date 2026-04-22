package com.aless.ejercicio2appsmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GreetingScreen(
    email: String,
    onBackToForm: () -> Unit
) {
    val userName = email.substringBefore("@").ifBlank { "usuario" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola $userName",
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            onClick = onBackToForm,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Regresar al formulario")
        }
    }
}

