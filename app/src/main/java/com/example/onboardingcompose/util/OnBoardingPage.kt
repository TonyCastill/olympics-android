package com.example.onboardingcompose.util

import androidx.annotation.DrawableRes
import com.example.onboardingcompose.R


/*In Android and Kotlin development, a sealed class is a special
  type of class that allows you to represent a restricted hierarchy
  of classes. A sealed class is abstract by nature, meaning you cannot
  instantiate it directly. It is used when you have a known set of possible subclasses,
  helping to model a fixed set of types in a more type-safe way.

*/
sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.customfirst,
        title = "Meeting",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second : OnBoardingPage(
        image = R.drawable.customfirst,
        title = "Coordination",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third : OnBoardingPage(
        image = R.drawable.customfirst,
        title = "Dialogue",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
