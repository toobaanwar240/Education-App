package com.example.eduguideapp.Navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.example.eduguideapp.FloatingButton


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    var showFAB by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(currentBackStackEntry) {
       showFAB = currentBackStackEntry?.destination?.route in appGraphRoute()
    }
    Scaffold(
        floatingActionButton = {
            if (showFAB) {
                FloatingButton(navController = navController)
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Destination.AuthRoute.route) {

            AuthGraph(navController)
            AppGraph(navController)


        }
    }
}

fun appGraphRoute():List<String>{
    return listOf(
        Destination.HomePage.route,
        Destination.SchedulePage.route,
        Destination.Notes.route,
        Destination.HomeWork.route
    )
}