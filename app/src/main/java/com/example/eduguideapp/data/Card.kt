package com.example.eduguideapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.R
import com.example.eduguideapp.ui.theme.EduGuide
import com.example.eduguideapp.ui.theme.Typography2

@Composable
fun MakeCard(data: Data){
    var isFilled by remember {
        mutableStateOf(false)
    }
    Card (
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Row (
            modifier = Modifier.background(data.color)
        ){
            Image(painter = painterResource(id = data.image) , contentDescription = "Image", modifier = Modifier
                .size(100.dp)
                .clip(
                    RoundedCornerShape(20.dp)
                ))

            Column {
                Text(text = data.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp), color = Color.Black)
                Text(text = data.time)
            }
            Spacer(modifier = Modifier.weight(0.05f))
            IconButton(onClick = {
                isFilled = !isFilled
            }) {
                Icon(imageVector =if(isFilled) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

                    , contentDescription ="Heart", modifier = Modifier
                        .padding(end = 15.dp, top = 12.dp)
                        .size(20.dp) )
            }


        }


    }
}

@Composable
fun SmallCard(data: SmallData) {
    Column (
        modifier = Modifier.padding(top = 15.dp)
    ){

        Row {
            Text(
                text = data.time,
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 20.dp, start = 10.dp)
            )
            Spacer(modifier = Modifier.padding(data.Padding))
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(data.color)
                    .padding(11.dp)
            ) {
                Column (
                    modifier = Modifier.background(data.color)
                ){
                    Text(
                        text = data.subject,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = data.timeduration,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SubjectCard(navController: NavController,data: SubjectData){
var isCheck by rememberSaveable {
    mutableStateOf(false)
}
    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .fillMaxWidth()
            .size(250.dp)
            .clip(
                RoundedCornerShape(20.dp),

                )
            .background(data.color).clickable { navController.navigate(Destination.HomeWorkSubjects.createRoute(data.id)) }
    ) {
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 20.dp, end = 8.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = "Homework",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 5.dp)
                )
                IconButton(onClick = { isCheck = !isCheck}) {
                    Image(
                        painter = if(isCheck){
                            painterResource(id = R.drawable.check)
                        }
                        else {
                            painterResource(id = R.drawable.minus )
                             },
                        contentDescription = "Check",
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                Color.Black
                            )
                            .size(20.dp)
                    )
                }
            }
        }
        Column {


            Image(
                painter = painterResource(id = data.icon2),
                contentDescription = "Calculator",
                modifier = Modifier
                    .padding(top = 30.dp, start = 10.dp)
                    .size(59.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = data.subject,
                style = Typography2.displayMedium,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 10.dp, top = 15.dp)
            )
            Text(
                text = data.time,
                fontSize = 17.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 14.dp)
            )
            Row(
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = data.image),
                    contentDescription = "Teacher",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(
                            RoundedCornerShape(50.dp)
                        )
                )
                Text(
                    text = data.tutor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp, start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun HomeWorkCard(data:HomeWork,navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(20.dp)
            )
            .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .clickable {
                navController.navigate(Destination.Lessons.createRoute(data.id))
            }

    ) {
        Row (
            modifier = Modifier
                .background(data.color)
                .clip(RoundedCornerShape(25.dp))
                .height(120.dp)
        ){

            Image(
                painter = painterResource(id = data.image),
                contentDescription = "ICONS",
                modifier = Modifier
                    .padding(10.dp)
                    .size(60.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
            )
            Column {
                Text(
                    text = data.subject,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp)
                )
                Text(
                    text = data.time,
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(end = 8.dp, top = 20.dp)
                    .weight(1f)
            )

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(EduGuide.lightGrey),
                modifier = Modifier.padding(top = 12.dp, end = 5.dp) // Apply padding to the Button
            ) {
                Text(
                    text = data.text,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black, // Change text color based on isCheck
                    modifier = Modifier.padding(8.dp) // Apply padding inside the Text
                )
            }

        }
    }
}
@Composable
fun NotificationCard(data: NotificationsData,onClick: () ->Unit){
    Card (onClick = onClick,

            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(20.dp)
                ).height(100.dp)
                .clickable { },
            colors = CardDefaults.cardColors(data.color)
    )
    {
        Row(
            modifier = Modifier

                .clip(RoundedCornerShape(25.dp))
                .padding(top=10.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = data.icon),
                contentDescription = "ICONS",
                modifier = Modifier
                    .padding(10.dp)
                    .size(60.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    )
            )
            Column {
                Text(
                    text = data.subject,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = 15.dp)
                )
                Text(
                    text = data.Text,
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}