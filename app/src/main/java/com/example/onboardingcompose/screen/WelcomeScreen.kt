package com.example.onboardingcompose.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.onboardingcompose.navigation.Screen
import com.example.onboardingcompose.util.OnBoardingPage //Contains image and texts
import com.example.onboardingcompose.viewmodel.WelcomeViewModel
import com.google.accompanist.pager.*

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel() //Initialize Welcome view model
) {
    val pages = listOf( //Call all pages
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState() //The current page

    Column(modifier = Modifier.fillMaxSize()) { //Fill all onboarding pages
        HorizontalPager( //We are able to scroll the pages dynamically

            /*Modifier.weight() is used to distribute space among
            composable elements within a layout, usually inside a
            Row or Column. When you use Modifier.weight() on a composable,
            you are telling the layout to allocate extra space to that composable
            based on the weight value provided.

            Proportional Allocation: The weight parameter determines how space
            is divided among the elements. A higher weight value means that composable
            will occupy more space.*/
            modifier = Modifier.weight(10f),
            count = 3, // Here we specify how many pages are
            state = pagerState, //The variable we declared above
            verticalAlignment = Alignment.Top
        ) { position -> // Index of pages
            PagerScreen(onBoardingPage = pages[position]) //Composable function
        }
        HorizontalPagerIndicator( //Represent the dots to define the position of the page
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState // The current page
        )
        FinishButton( //Visible only after we reach the final page
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) { //Action of the button
            welcomeViewModel.saveOnBoardingState(completed = true) // Complete the onboarding process
            navController.popBackStack() // Once welcome screen is executed, it will be poped up for the back stack
            navController.navigate(Screen.Home.route) //Navigate to home
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) { //All pages for onboarding screens
    // It accepts OnBoardingPage object
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top
    ) {
        Image( //The image
            modifier = Modifier

                .fillMaxSize(),
                //.fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image",
            contentScale= ContentScale.Crop

        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp,0.dp,0.dp,100.dp)
        ){
            Text( //Title
                modifier = Modifier
                    .fillMaxWidth(),
                text = onBoardingPage.title,
                color=Color.White,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text( //Description
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 20.dp),
                text = onBoardingPage.description,
                color = Color.White,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton( //Just displays at the end
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility( // Only dispays when a condition is met
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2 //The condition is that the current page is 2 (lastone)
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}


//This only previews the pages
@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}