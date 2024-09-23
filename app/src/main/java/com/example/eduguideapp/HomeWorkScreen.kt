package com.example.eduguideapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.data.HomeWork
import com.example.eduguideapp.data.HomeWorkCard
import com.example.eduguideapp.data.HomeWorkRepo
import kotlinx.coroutines.delay

@Composable
fun HomeWorkScreen(navController: NavController,data :List<HomeWork> = HomeWorkRepo.homeworkdata){
    var search2 by remember {
        mutableStateOf("")
    }

    Scaffold()
    {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Row {
                TextButton(onClick = { navController.navigate(Destination.Notes.route) }) {
                    Text(
                        text = "Subjects",
                        fontSize = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        modifier = Modifier.padding(end = 80.dp)
                    )
                }
                TextButton(onClick = {  }) {

                        Text(
                            text = "HomeWork",
                            fontSize = 29.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(end = 5.dp)
                        )

                }
            }
            TextField(value = search2, onValueChange = { search2 = it }, modifier = Modifier
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
                   text = "Tuesday",
                   fontSize = 34.sp,
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 25.dp)
               )
               Text(
                   text = "4 tasks",
                   fontSize = 24.sp,
                   color = Color.Gray,
                   modifier = Modifier.padding(start = 15.dp, top = 30.dp)
               )
               Spacer(modifier = Modifier.weight(1f))
               Image(painter = painterResource(id = R.drawable.calendar2), contentDescription ="Calender", modifier = Modifier
                   .padding(end = 10.dp, top = 21.dp)
                   .size(40.dp)
                   .clickable {
                       navController.navigate(Destination.SchedulePage.route)
                   })
           }
          LazyColumn {
              itemsIndexed(data){index,homeworkdata ->
                  var isVisible by remember {
                      mutableStateOf(false)
                  }
                  LaunchedEffect(Unit) {
                      delay(index * 80L)
                      isVisible = true
                  }
                  AnimatedVisibility(visible = isVisible,
                      enter = slideInHorizontally (initialOffsetX = {it})+ fadeIn(animationSpec = tween(700)),
                      exit = slideOutHorizontally (targetOffsetX = {it})+ fadeOut(animationSpec = tween(700))
                  ) {
                      HomeWorkCard(data = homeworkdata,navController)
                  }

              }
          }
        }
    }
}