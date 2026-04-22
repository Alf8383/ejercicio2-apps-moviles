package com.aless.ejercicio2appsmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aless.ejercicio2appsmoviles.ui.screens.FormScreen
import com.aless.ejercicio2appsmoviles.ui.screens.GreetingScreen
import com.aless.ejercicio2appsmoviles.ui.screens.HomeScreen
import com.aless.ejercicio2appsmoviles.ui.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Main.route
    ) {
        composable(AppRoute.Main.route) {
            MainScreen(
                onGoHome = { navController.navigate(AppRoute.Home.route) },
                onGoForm = { navController.navigate(AppRoute.Form.route) }
            )
        }
        composable(AppRoute.Home.route) {
            HomeScreen(
                onBackToMain = {
                    navController.navigateToMain()
                }
            )
        }
        composable(AppRoute.Form.route) {
            FormScreen(
                onSubmit = { email ->
                    navController.navigate(AppRoute.Greeting.createRoute(email))
                },
                onBackToMain = {
                    navController.navigateToMain()
                }
            )
        }
        composable(AppRoute.Greeting.route) { backStackEntry ->
            val email = backStackEntry.arguments
                ?.getString(AppRoute.Greeting.EMAIL_ARG)
                .orEmpty()

            GreetingScreen(
                email = email,
                onBackToForm = {
                    navController.popBackStack()
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

