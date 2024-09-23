package com.example.eduguideapp.Navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.eduguideapp.LoginPage
import com.example.eduguideapp.MainScreen
import com.example.eduguideapp.Notification
import com.example.eduguideapp.SignInPage

fun NavGraphBuilder.AuthGraph(navController: NavController){
    navigation(startDestination = Destination.Home.route, route = Destination.AuthRoute.route) {
        composable(Destination.Home.route,
            enterTransition = { fadeIn() + slideInVertically(initialOffsetY = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut() + slideOutVertically(targetOffsetY = {-1000}, animationSpec = tween(700)) }) {
            MainScreen(navController)
        }
        composable(Destination.Login.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700)) }) {
            LoginPage(navController)
        }
        composable(Destination.Sign.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700)) }) {
            SignInPage(navController)
        }

    }
}