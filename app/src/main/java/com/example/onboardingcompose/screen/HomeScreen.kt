package com.example.onboardingcompose.screen

import android.annotation.SuppressLint
import android.media.Image
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingcompose.R


//@Preview(showBackground = true)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() { //Main screen, here is the place to work with the view



    Scaffold (
        bottomBar = {
            BottomAppBar(
                contentColor = Color.LightGray,
                //contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
    ){
        /*TODO*/
        VerticalHorizontalScroll()
    }
    /*Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
    }*/
    /*Surface(color =MaterialTheme.colors.background){ //Place to draw everything
       VerticalHorizontalScroll()
    }*/
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
            .background(Color.DarkGray)
    ){

        // Title Medallas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF4A72D8), // Yellow
                            Color(0xFF0C1A8B), // Yellow
                            Color(0xFF040D4E)  // Orange

                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text ="Medallas",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier=Modifier.padding(0.dp,50.dp)

            )

        }

        //Options
        Column(modifier=Modifier.background(color = Color.Black)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Arrange items at both ends

            )
            {
                Column(horizontalAlignment = Alignment.Start
                ){
                    Box( //Favorites
                        modifier= Modifier
                            .size(58.dp) // Total size of the container
                            .padding(5.dp) // Inner padding around the icon
                            .border(2.dp, Color.White),

                        ){
                        val interactionSource = remember { MutableInteractionSource() }

                        Button(
                            onClick = { /*TODO*/ println("This is a debug message")},
                            modifier = Modifier.fillMaxSize()
                                .hoverable(interactionSource = interactionSource)
                                .focusable(interactionSource = interactionSource),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent
                                )
                            ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id =R.drawable.customfavorite),
                                contentDescription = "Favorite Icon",
                                tint = Color.White,
                                //contentScale=ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(70.dp)



                            )

                        }
                        /*Row(
                            modifier=Modifier
                                .align(Alignment.Center)
                        ){
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "Favorite Icon",
                                tint = Color.White

                            )
                            Icon(
                                imageVector = Icons.Outlined.ArrowDropDown,
                                contentDescription = "Favorite Icon",
                                tint = Color.White
                            )
                        }*/

                    }
                }

                Row(){
                    Column(horizontalAlignment = Alignment.End) {
                        Box( //Favorites
                            modifier= Modifier
                                .size(58.dp) // Total size of the container
                                .padding(5.dp) // Inner padding around the icon
                                .border(2.dp, Color.White),

                            ){
                            Row(
                                modifier=Modifier
                                    .align(Alignment.Center)
                            ){
                                Icon(
                                    imageVector = Icons.Outlined.Add,
                                    contentDescription = "Favorite Icon",
                                    tint = Color.White,


                                )
                            }

                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Box( //Favorites
                            modifier= Modifier
                                .size(58.dp) // Total size of the container
                                .padding(5.dp) // Inner padding around the icon
                                .border(2.dp, Color.White),

                            ){
                            Row(
                                modifier=Modifier
                                    .align(Alignment.Center)
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id =R.drawable.updown),
                                    contentDescription = "Favorite Icon",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Box( //Favorites
                            modifier= Modifier
                                .size(58.dp) // Total size of the container
                                .padding(5.dp) // Inner padding around the icon
                                .border(2.dp, Color.White),

                            ){
                            Row(
                                modifier=Modifier
                                    .align(Alignment.Center)
                            ){
                                Icon(
                                    imageVector = ImageVector.vectorResource(id =R.drawable.configuration),
                                    contentDescription = "Favorite Icon",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                        }
                    }
                }



            }
        }

        //Marcador - Score
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Set the width to 70% of the parent
                    .background(color = Color.DarkGray),
                horizontalArrangement = Arrangement.SpaceBetween // Arrange items at both ends
            ){
                //NPCs
                Row(
                        modifier= Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.5f),
                        verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "#",
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp))
                    Text(text = "NPCs",
                        color = Color.Black,
                        fontSize = 20.sp,)
                }

                //Medals
                Row(
                    modifier= Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){

                    Image(
                        painter = painterResource(id = R.drawable.goldmedal) ,
                        contentDescription = "Custom SVG Icon",
                        modifier = Modifier
                            .size(20.dp) // Adjust the size as needed
                            .fillMaxWidth(0.25f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.silvermedal) ,
                        contentDescription = "Custom SVG Icon",
                        modifier = Modifier
                            .size(20.dp) // Adjust the size as needed
                            .fillMaxWidth(0.25f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.broncemedal) ,
                        contentDescription = "Custom SVG Icon",
                        modifier = Modifier
                            .size(20.dp) // Adjust the size as needed
                            .fillMaxWidth(0.25f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.threemedals) ,
                        contentDescription = "Custom SVG Icon",
                        modifier = Modifier
                            .size(20.dp) // Adjust the size as needed
                            .fillMaxWidth(0.25f)
                    )
                }

            }
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