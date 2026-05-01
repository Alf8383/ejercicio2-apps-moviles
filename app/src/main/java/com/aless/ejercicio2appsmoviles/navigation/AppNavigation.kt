package com.aless.ejercicio2appsmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aless.ejercicio2appsmoviles.ui.screens.FormScreen
import com.aless.ejercicio2appsmoviles.ui.screens.GreetingScreen
import com.aless.ejercicio2appsmoviles.ui.screens.HomeScreen
import com.aless.ejercicio2appsmoviles.ui.screens.InventoryScreen
import com.aless.ejercicio2appsmoviles.ui.screens.MainScreen
import com.aless.ejercicio2appsmoviles.ui.screens.SinStockScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Main.route
    ) {
        composable(AppRoute.Main.route) {
            InventoryScreen(
                onSinStock = {
                    navController.navigate(AppRoute.OutOfStock.route) {
                        popUpTo(AppRoute.Inventory.route) { inclusive = true }
                    }
                }
            )
        }
        composable(AppRoute.Inventory.route) {
            InventoryScreen(
                onSinStock = {
                    navController.navigate(AppRoute.OutOfStock.route) {
                        popUpTo(AppRoute.Inventory.route) { inclusive = true }
                    }
                }
            )
        }
        composable(AppRoute.OutOfStock.route) {
            SinStockScreen(
                onBackToMain = {
                    navController.navigateToMain()
                }
            )
        }
    }
}

private fun NavHostController.navigateToMain() {
    navigate(AppRoute.Main.route) {
        popUpTo(AppRoute.Main.route) {
            inclusive = true
        }
        launchSingleTop = true
    }
}

