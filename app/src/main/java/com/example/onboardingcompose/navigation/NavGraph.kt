package com.example.onboardingcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboardingcompose.screen.HomeScreen
import com.example.onboardingcompose.screen.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph( //Calling from the main activity
    navController: NavHostController,
    startDestination: String //By the view model
) {
    NavHost(
        navController = navController,
        startDestination = startDestination //At the beginning was Screen.Welcome.route
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}