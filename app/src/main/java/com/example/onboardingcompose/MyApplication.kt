package com.example.onboardingcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Dependency inyection
class MyApplication: Application()