package com.example.onboardingcompose.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboardingcompose.data.DataStoreRepository
import com.example.onboardingcompose.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository //Uses the repository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading //Used for the splash screen to decide when to close it

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination //Observed from the application and its value will be passed to the navigation graph

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.Home.route
                } else {
                    _startDestination.value = Screen.Welcome.route
                }
            }
            _isLoading.value = false
        }
    }

}