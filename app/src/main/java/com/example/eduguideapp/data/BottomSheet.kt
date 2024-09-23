package com.example.eduguideapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.eduguideapp.ui.theme.EduGuide

@Composable
fun BottomSheetContent(navController: NavController,data: BottomSheetData){
    Column (
            modifier = Modifier
                .height(500.dp)
                .background(data.color)
    ){
        Box(modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .size(60.dp)
            .background(Color.White)){
            Text(text = data.grade, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(
                Alignment.Center))
        }
        Text(text = data.text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp, start = 15.dp))
        Card (
            modifier = Modifier
                .padding(24.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White)
        ){
            Column {
                Text(text = data.subject, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(start = 15.dp, top = 14.dp))
                Text(text = "Today at 1:15pm", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Gray, modifier = Modifier.padding(start = 15.dp, top = 8.dp))
                Row {
                    Image(painter = painterResource(id = data.tutorimage), contentDescription ="Tutor",
                        Modifier
                            .padding(17.dp)
                            .size(60.dp)
                            .clip(
                                RoundedCornerShape(30.dp)
                            ) )
                    Text(text = data.tutor,fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(top = 30.dp))
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navController.navigate(Destination.Lessons.createRoute(data.id.toString()))
        }, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(bottom = 70.dp)
            .height(60.dp)) {
            Text(text = "Lesson Materials", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}