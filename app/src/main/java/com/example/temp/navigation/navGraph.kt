package com.example.temp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.temp.ButtonScreen
import com.example.temp.screen.ImageScreen

@Composable
fun setupNavGraph(
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(Routes.HomeScreen.route) {
            ButtonScreen(navController = navHostController)
        }
        composable(Routes.ImageScreen.route) {
            ImageScreen()
        }
    }
}