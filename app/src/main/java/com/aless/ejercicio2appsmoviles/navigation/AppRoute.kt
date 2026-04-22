package com.aless.ejercicio2appsmoviles.navigation

import android.net.Uri

sealed class AppRoute(val route: String) {
    data object Main : AppRoute("main")
    data object Home : AppRoute("home")
    data object Form : AppRoute("form")

    data object Greeting : AppRoute("greeting/{email}") {
        const val EMAIL_ARG = "email"

        fun createRoute(email: String): String {
            return "greeting/${Uri.encode(email)}"
        }
    }
}

