package com.example.eduguideapp


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check

import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.data.Data
import com.example.eduguideapp.data.DataRepository
import com.example.eduguideapp.data.MakeCard
import com.example.eduguideapp.ui.theme.EduGuide
import com.example.eduguideapp.ui.theme.Typography2


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable

fun HomePageComp(navController: NavController,data: List<Data> = DataRepository.datas) {

    Scaffold (

    ){innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HomePage(navController)
            LazyColumn(
                contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding()),
                modifier = Modifier.fillMaxSize()
            ) {
                items(data) { dataItem ->
                    MakeCard(data = dataItem)
                }

            }

        }
    }
}
@Composable
fun HomePage(navController: NavController) {
    var searchbar by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,

        ) {
        Row(
            Modifier.padding(start = 20.dp, top = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar2l),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(100.dp))
            )
            Column {
                Text(
                    text = "Tooba Anwar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp, start = 5.dp)
                )
                Text(
                    text = "6th Grade ",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navController.navigate(Destination.Notifications.route) }) {
                BadgedBox(badge = {
                    Badge(modifier = Modifier.size(12.dp).align(Alignment.TopEnd))
                }) {
                    Icon(
                        imageVector = Icons.Sharp.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier.size(35.dp)
                    )
                }

            }

        }
        TextField(value = searchbar, onValueChange = { searchbar = it }, modifier = Modifier
            .padding(15.dp)
            .clip(
                RoundedCornerShape(25.dp)
            )
            .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = { Text(text = "Search", fontSize = 20.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(30.dp)
                )
            }
        )
        Row {
            Text(
                text = "Next Class",
                style = Typography2.displayMedium,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "See all", fontSize = 24.sp, modifier = Modifier
                .padding(end = 10.dp)
                .clickable { })
        }
        Box(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 15.dp)
                .fillMaxWidth()
                .size(250.dp)
                .clip(
                    RoundedCornerShape(20.dp),

                    )
                .background(EduGuide.lightblue)
        ) {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .padding(start = 190.dp, top = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Row {

                    Text(
                        text = "Homework",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Check",
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                Color.Black
                            )
                            .size(25.dp)
                    )
                }
            }
            Column {


                Image(
                    painter = painterResource(id = R.drawable.calculator2),
                    contentDescription = "Calculator",
                    modifier = Modifier
                        .padding(top = 30.dp, start = 10.dp)
                        .size(59.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(
                    text = "Basic Mathematics",
                    style = Typography2.displayMedium,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp)
                )
                Text(
                    text = "Today at 8:05 PM",
                    fontSize = 17.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 14.dp)
                )
                Row(
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "Teacher",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(
                                RoundedCornerShape(50.dp)
                            )
                    )
                    Text(
                        text = "Jane Cooper",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 15.dp, start = 8.dp)
                    )
                }
            }
        }


        Text(
            text = "Upcoming Events",
            style = Typography2.displayMedium,
            fontSize = 28.sp,
            modifier = Modifier.padding(start = 10.dp)
        )


    }

}

