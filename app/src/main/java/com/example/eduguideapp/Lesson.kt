package com.example.eduguideapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.eduguideapp.data.LessonRepo.getlessonbyId
import com.example.eduguideapp.ui.theme.EduGuide


@Composable
fun Lesson(lessonId: String?,navController: NavController) {
    val lessondata = lessonId?.let { getlessonbyId(it) }
    var isCheck by remember {
        mutableStateOf(false)
    }
    Scaffold (

    ){innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp, top = 8.dp)
                        .size(40.dp)
                        .background(
                            Color.White
                        )
                        .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                        .clickable {
                          navController.navigate(Destination.HomeWork.route)
                        }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back", modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
                if (lessondata != null) {
                    Text(
                        text = lessondata.subject,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                    )
                }
            }
            HorizontalDivider(modifier = Modifier.padding(top = 18.dp))
            Text(text = "Lesson Theme", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp, top = 15.dp))
            if (lessondata != null) {
                Text(text =lessondata.description, fontSize = 18.sp, color = Color.Gray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 20.dp, start = 10.dp, end = 10.dp))
            }
            Text(text = "Additional Materials", fontSize = 27.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp, bottom = 20.dp))
            Row (
                modifier = Modifier.padding(15.dp)
            ){
                if (lessondata != null) {
                    Image(painter = painterResource(lessondata.images1),contentDescription = "English", modifier = Modifier
                        .size(200.dp)
                        .padding(20.dp))
                }
                if (lessondata != null) {
                    Image(painter = painterResource(id = lessondata.images2), contentDescription = "English",modifier = Modifier.size(200.dp))
                }
            }
            Text(text = "Homework", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp, top = 15.dp))
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(EduGuide.lightGrey),
                modifier = Modifier

                    .padding(top = 20.dp, end = 8.dp, start = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Text(
                        text = "Attached",
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
                                .size(25.dp)
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {
                if (lessondata != null) {
                    navController.navigate(Destination.HomeWorkSubjects.createRoute(lessondata.id))
                }
            }, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 40.dp).height(60.dp)) {
                Text(text = "Lesson Tutorials", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}