package com.example.eduguideapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.eduguideapp.Navigation.Destination


@Composable
fun FloatingButton(navController: NavController) {
    Column (
        modifier = Modifier.padding(start = 20.dp, end = 25.dp)
    ){


        Row(

            modifier = Modifier

                .padding(8.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Transparent)
        ) {
            FloatingActionButton(

                onClick = {
                    navController.navigate(Destination.HomePage.route)
                },
                containerColor = Color.White,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)

            ) {

                Image(
                    painter = painterResource(id = R.drawable.home2),
                    contentDescription = "Home",
                    modifier = Modifier.size(40.dp)
                )
            }
            FloatingActionButton(
                onClick = {
                    navController.navigate(Destination.SchedulePage.route)
                },
                containerColor = Color.White,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)

            ) {

                Icon(
                    painter = painterResource(id = R.drawable.calendar2),
                    contentDescription = "calender",
                    modifier = Modifier.size(40.dp)
                )
            }
            FloatingActionButton(
                onClick = {navController.navigate(Destination.Notes.route)},
                containerColor = Color.White,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)

            ) {

                Icon(
                    painter = painterResource(id = R.drawable.notes),
                    contentDescription = "notes",
                    modifier = Modifier.size(40.dp)
                )
            }
            FloatingActionButton(
                onClick = {  },
                containerColor = Color.White,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)

            ) {

                Icon(
                    painter = painterResource(id = R.drawable.messageicon),
                    contentDescription = "message",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}