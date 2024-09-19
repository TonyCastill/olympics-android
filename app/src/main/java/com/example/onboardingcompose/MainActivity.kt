package com.example.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.onboardingcompose.navigation.SetupNavGraph
import com.example.onboardingcompose.ui.theme.OnBoardingComposeTheme
import com.example.onboardingcompose.viewmodel.SplashViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { //Impelement splash screen
            !splashViewModel.isLoading.value
        }

        setContent {
            OnBoardingComposeTheme {
                val screen by splashViewModel.startDestination //Observe the value from the view model, used at the composable function
                val navController = rememberNavController() //nav controller of onboarding pages
                SetupNavGraph(navController = navController, startDestination = screen)
            }
        }
    }
}