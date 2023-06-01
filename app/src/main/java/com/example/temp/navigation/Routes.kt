package com.example.temp.navigation

sealed class Routes(val route: String) {
    object HomeScreen : Routes(route = "HomeScreen")
    object ImageScreen : Routes(route = "ImageScreen")
}

