package com.aless.ejercicio2appsmoviles.navigation

import android.net.Uri

sealed class AppRoute(val route: String) {
    data object Main : AppRoute("main")
    data object Inventory : AppRoute("inventory")
    data object OutOfStock : AppRoute("out_of_stock")

}

