package com.example.myportfolio.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myportfolio.MainActivity
import com.example.myportfolio.MainFunction
import com.example.myportfolio.ui.theme.MyPortfolioTheme


@Composable
fun ScreenMain() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {

        // First route : Home
        composable("main") {

            // Lay down the Home Composable
            // and pass the navController
            MainFunction( listProjects = Projects().listProjects,
                listCourses = Projects().listProjects,
                navController = navController)
        }

        // Another Route : Profile
        composable("json") {
            // Profile Screen
            ShowInformation(projectName = "fbWFBWMENfm")
        }

        // Settings Route, Notice the "/{id}" in last,
        // its the argument passed down from homeScreen
        composable(" ") { navBackStack ->

            // Extracting the argument
            val counter = navBackStack.arguments?.getString("id")

            // Setting screen,
            // Pass the extracted Counter
            ShowInformation("fjggwefbfwehfe sfasbdagws")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPortfolioTheme {
        ScreenMain()
    }
}