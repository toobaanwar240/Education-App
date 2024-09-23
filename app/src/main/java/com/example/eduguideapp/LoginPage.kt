package com.example.eduguideapp


import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eduguideapp.Navigation.Destination

import com.example.eduguideapp.ui.theme.EduGuide



@Composable
fun LoginPage(navController: NavController) {
    var user by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current

    var isClick by rememberSaveable {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.background(EduGuide.blue), shape = RoundedCornerShape(200.dp,0.dp,200.dp,0.dp)
    ) {
        AnimatedContent(targetState = isClick, transitionSpec = {
            if(isClick){
                slideInHorizontally { fullWidth -> fullWidth }+ fadeIn() togetherWith fadeOut()
            }
            else{
                fadeIn() togetherWith fadeOut()
            }
        }, label = "") { targetState ->
            if (targetState) {
               navController.navigate(Destination.HomePage.route)
            } else {
                Column(

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.book),
                        contentDescription = "Book image",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(
                                RoundedCornerShape(40.dp)
                            )
                    )
                    Text(
                        text = "Welcome to EDUGUIDE",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 20.dp,
                            end = 20.dp,
                            bottom = 5.dp
                        )
                    )
                    Text(
                        text = " Keep your data safe ",
                        fontSize = 17.sp,

                        color = Color.Gray,
                        modifier = Modifier.padding(start = 20.dp, bottom = 20.dp)
                    )


                    TextField(
                        value = user,
                        onValueChange = { user = it },
                        label = { Text(text = "Enter your name") },
                        modifier = Modifier
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Enter password") },
                        modifier = Modifier
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(
                        onClick = {
                            if (password != "Tooba") {
                                Toast.makeText(context, "Invalid Password", Toast.LENGTH_LONG)
                                    .show()
                            } else {
                                isClick = true
                            }

                        },
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("Login", fontSize = 20.sp)
                    }
                    Row {
                        Text(text = "Don't have a account? ", fontSize = 17.sp, color = Color.Gray)
                        Text(text = "Register now",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = EduGuide.Darkblue,
                            modifier = Modifier.clickable {
                                navController.navigate(Destination.Sign.route)
                            })
                    }


                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginPage(navController = rememberNavController())
}