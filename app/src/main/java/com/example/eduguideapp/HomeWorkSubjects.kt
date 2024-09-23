package com.example.eduguideapp

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.data.SubjectData
import com.example.eduguideapp.data.SubjectDataRepo.getSubjectbyId
import com.example.eduguideapp.data.YouTubeVideo
import com.example.eduguideapp.ui.theme.EduGuide


@Composable
fun HomeWorkSubjects(subjectId: String?,navController: NavController) {
    val subjectdata =subjectId?.let { getSubjectbyId(it) }
    Scaffold (){innerPadding ->
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
                           navController.navigate(Destination.Notes.route)
                        }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back", modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
                if (subjectdata != null) {
                    Text(text = subjectdata.subject, fontSize = 27.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                }
            }
            HorizontalDivider(modifier = Modifier.padding(top = 18.dp))
            Text(text = "Lesson Tutorial", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 20.dp, start = 10.dp))
            LazyRow {
                item {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .padding(8.dp)
                            .size(width = 300.dp, height = 200.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.elevatedCardElevation(4.dp),
                        colors = CardDefaults.cardColors(Color.Transparent)

                    ) {
                        YouTubeVideo(
                            YouTuberId = "aaJo07SrSWQ",
                            lifecycleOwner = LocalLifecycleOwner.current
                        )

                    }
                }
                item {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .padding(8.dp)
                            .size(width = 300.dp, height = 200.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.elevatedCardElevation(4.dp),
                                colors = CardDefaults.cardColors(Color.Transparent)
                    ){
                        YouTubeVideo(YouTuberId = "OmJ-4B-mS-Y", lifecycleOwner = LocalLifecycleOwner.current)
                    }
                }
                item {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .padding(8.dp)
                            .size(width = 300.dp, height = 200.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.elevatedCardElevation(4.dp),
                                colors = CardDefaults.cardColors(Color.Transparent)
                      ){
                        YouTubeVideo(YouTuberId = "Kp2bYWRQylk", lifecycleOwner = LocalLifecycleOwner.current)

                    }

                }
                item {
                    Card(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .padding(8.dp)
                            .size(width = 300.dp, height = 200.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.elevatedCardElevation(4.dp),
                        colors = CardDefaults.cardColors(Color.Transparent)

                    ){
                        YouTubeVideo(YouTuberId = "0Be_6Qaq1es", lifecycleOwner = LocalLifecycleOwner.current)
                    }
                }
            }
            Text(text = "Tasks", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 15.dp))
            LazyColumn {
                item {
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(80.dp),
                        colors = CardDefaults.cardColors(EduGuide.lightGrey)
                    ){
                        Row (
                            modifier = Modifier
                                .padding(top = 30.dp)

                        ){
                            Text(text = "Task 1", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp, end = 20.dp))
                            Text(text = "30 min", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "Uploaded", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 10.dp))
                        }
                    }
                }
                item {
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(80.dp),
                        colors = CardDefaults.cardColors(EduGuide.lightGrey)
                    ){
                        Row (
                            modifier = Modifier
                                .padding(top = 30.dp)

                        ){
                            Text(text = "Task 2", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp, end = 20.dp))
                            Text(text = "40 min", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "To Do", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 10.dp))
                        }
                    }
                }
                item {
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(80.dp),
                        colors = CardDefaults.cardColors(EduGuide.lightGrey)
                    ){
                        Row (
                            modifier = Modifier
                                .padding(top = 30.dp)

                        ){
                            Text(text = "Task 3", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp, end = 20.dp))
                            Text(text = "30 min", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "To Do", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 10.dp))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {
                if (subjectdata != null) {
                    navController.navigate(Destination.HomeWorkSubjects.createRoute(subjectdata.id))
                }
            }, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 40.dp).height(60.dp)) {
                Text(text = "Lesson Materials", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}