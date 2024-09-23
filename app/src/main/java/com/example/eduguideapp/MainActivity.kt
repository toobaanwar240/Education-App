package com.example.eduguideapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.eduguideapp.Navigation.NavGraph

import com.example.eduguideapp.ui.theme.EDUGUIDEAPPTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          EDUGUIDEAPPTheme {
               NavGraph()
          }
        }
    }
}

