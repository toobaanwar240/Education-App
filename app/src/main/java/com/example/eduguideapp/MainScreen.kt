package com.example.eduguideapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.eduguideapp.Navigation.Destination

import com.example.eduguideapp.ui.theme.Typography2

@Composable
fun MainScreen(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(composition,
        iterations = LottieConstants.IterateForever)
    
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            modifier = Modifier.size(400.dp),
            composition = composition,
            progress = progress)
        Text(text = "The only study app ", style = Typography2.displayLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        Text(text = "you'll ever need", style = Typography2.displayLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(bottom = 10.dp))

        Text(text = "Upload class study materials, create electronic flashcards to study", fontSize = 23.sp, color = Color.Gray, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))
Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = {
          navController.navigate(Destination.Login.route)
        }, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier
            .padding(10.dp)
            .height(60.dp)
            .width(150.dp)) {
            Text(text = "Let's Start", fontSize = 20.sp)
        }
    }
}