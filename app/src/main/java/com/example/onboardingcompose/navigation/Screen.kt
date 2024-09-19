package com.example.onboardingcompose.navigation

sealed class Screen(val route: String) { //Here we define screens
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
}