package com.example.eduguideapp


import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

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
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.ui.theme.EduGuide


@Composable
fun SignInPage(navController: NavController) {
    var user2 by rememberSaveable {
        mutableStateOf("")
    }
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var password2 by rememberSaveable {
        mutableStateOf("")
    }
    var password3 by rememberSaveable {
        mutableStateOf("")
    }



    Surface(
        modifier = Modifier.background(EduGuide.blue),
        shape = RoundedCornerShape(200.dp,0.dp,200.dp,0.dp),

    ) {
        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White).padding(16.dp)
        ) {

            Text(
                text = "Register Now!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text(
                text = " Keep your data safe ",
                fontSize = 17.sp,

                color = Color.Gray,
                modifier = Modifier.padding(start = 15.dp, bottom = 20.dp)
            )


            TextField(
                value = user2,
                onValueChange = { user2 = it },
                label = { Text(text = "Enter email_id") },
                modifier = Modifier
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,)
            )
            TextField(
                value = username,
                onValueChange = { username = it},
                label = { Text(text = "Enter user name") },
                modifier = Modifier
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,)
            )

            TextField(
                value = password2,
                onValueChange = { password2 = it },
                label = { Text(text = "Enter password") },
                modifier = Modifier
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                )
            )
            TextField(
                value = password3,
                onValueChange = { password3 = it },
                label = { Text(text = "Confirm Password") },
                modifier = Modifier
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {
                      navController.navigate(Destination.HomePage.route)
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Sign up", fontSize = 20.sp)
            }

        }
    }
}