package com.example.onboardingcompose.screen

import android.media.Image
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingcompose.R

@Composable
fun HomeScreen() { //Main screen, here is the place to work with the view
    /*Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }*/
    Surface(color =MaterialTheme.colors.background){ //Place to draw everything
       VerticalHorizontalScroll()
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}


@Composable
fun VerticalHorizontalScroll(){ // Main function to draw everything, inside the surface
    Column( //Main column to display all
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.Magenta),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text ="Comopose Nested Scroll view",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )

        }
        LazyColumn { //You can scroll them to the bottom
            item {
                Text(text ="Recent list",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }

            //Horizontal Scroll View
            item{
                LazyRow {
                    items(count=10){ //put items on it
                        Card( // Pattern that applies to all the 10 items
                          modifier = Modifier
                              .width(110.dp)
                              .height(120.dp)
                              .padding(10.dp, 5.dp, 5.dp, 0.dp)
                              .clip(RoundedCornerShape(10.dp)) // Like border radius
                              .background(Color.White),
                            elevation = 6.dp // adds a shadow

                        ){
                            Column(
                                modifier= Modifier
                                    .padding(5.dp),
                                horizontalAlignment=Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                //Continuar 4:49 https://www.youtube.com/watch?v=wL9mVkgeFys
                                Image(painter=painterResource(id = R.drawable.sushi),
                                    contentDescription = "sushi",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                    )
                                Spacer(modifier = Modifier.padding(5.dp)) //Leaves some space

                                Text(
                                    text="Test",
                                    color=Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                    )

                            }

                        }
                    }
                    item {
                        Card( // Pattern that applies to all the 10 items
                            modifier = Modifier
                                .width(110.dp)
                                .height(120.dp)
                                .padding(10.dp, 5.dp, 5.dp, 0.dp)
                                .clip(RoundedCornerShape(10.dp)) // Like border radius
                                .background(Color.White),
                            elevation = 6.dp // adds a shadow

                        ){
                            Column( //Array of elements ordered vertically
                                modifier= Modifier
                                    .padding(5.dp),
                                horizontalAlignment=Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                //Continuar 4:49 https://www.youtube.com/watch?v=wL9mVkgeFys
                                Image(painter=painterResource(id = R.drawable.rings2),
                                    contentDescription = "sushi",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                                Spacer(modifier = Modifier.padding(5.dp)) //Leaves some space

                                Text(
                                    text="Test",
                                    color=Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )

                            }

                        }
                    }
                }
            }
            item {
                Text(text ="Items list",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
            items(count = 10){
                Card( // Pattern that applies to all the 10 items
                    modifier = Modifier
                        //.width(110.dp)
                        .height(100.dp)
                        .padding(10.dp, 5.dp, 5.dp, 0.dp)
                        .clip(RoundedCornerShape(10.dp)) // Like border radius
                        .fillMaxWidth()
                        .background(Color.White),

                    elevation = 6.dp // adds a shadow

                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier

                        ){
                            Image(painter=painterResource(id = R.drawable.sushi),
                                contentDescription = "sushi",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)

                            )
                            Spacer(modifier = Modifier.padding(5.dp)) //Leaves some space
                            Column {
                                Text(
                                    text="Test",
                                    color=Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "sdfsadfdasf"
                                )
                            }

                        }
                    }
                }
            }
        }

    }

}