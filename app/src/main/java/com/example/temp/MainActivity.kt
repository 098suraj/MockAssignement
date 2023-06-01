package com.example.temp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.temp.navigation.Routes
import com.example.temp.navigation.setupNavGraph
import com.example.temp.ui.theme.TempTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TempTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    setupNavGraph(
                        navHostController = navHostController,
                        startDestination = Routes.HomeScreen.route
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonScreen(modifier: Modifier = Modifier,navController: NavController) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate(Routes.ImageScreen.route) }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "View Images")
        }
    }
}