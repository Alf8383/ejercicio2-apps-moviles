package com.aless.ejercicio2appsmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class HomeTab(val label: String, val message: String) {
    Inicio("Inicio", "Hola mundo"),
    Perfil("Perfil", "Bienvenido a la segunda opción")
}

@Composable
fun HomeScreen(
    onBackToMain: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(HomeTab.Inicio) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                HomeTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Text(tab.label.take(1)) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        HomeContent(
            paddingValues = innerPadding,
            message = selectedTab.message,
            onBackToMain = onBackToMain
        )
    }
}

@Composable
private fun HomeContent(
    paddingValues: PaddingValues,
    message: String,
    onBackToMain: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            onClick = onBackToMain,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Regresar a principal")
        }
    }
}

