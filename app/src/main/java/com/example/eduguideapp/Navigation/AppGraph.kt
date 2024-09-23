package com.example.eduguideapp.Navigation


import android.os.Build
import androidx.annotation.RequiresApi
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

import com.example.eduguideapp.HomePageComp
import com.example.eduguideapp.HomeWorkScreen
import com.example.eduguideapp.HomeWorkSubjects
import com.example.eduguideapp.Lesson
import com.example.eduguideapp.NotesScreen
import com.example.eduguideapp.Notification
import com.example.eduguideapp.ScheduleScreenComp



@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.AppGraph(navController: NavController) {
    navigation(
        startDestination = Destination.HomePage.route,
        route = Destination.AppRoute.route
    ) {
        composable(Destination.HomePage.route, enterTransition = { fadeIn()+ slideInVertically(initialOffsetY = {1000}, animationSpec = tween(700)) },
                           exitTransition = { fadeOut()+ slideOutVertically(targetOffsetY = {1000}, animationSpec = tween(700)) }
            ) {
            HomePageComp(navController)
        }
        composable(Destination.SchedulePage.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700)) }) {
            ScheduleScreenComp()

        }
        composable(Destination.Notes.route){
            NotesScreen(navController)
        }
        composable(Destination.HomeWork.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700)) }
            ){
            HomeWorkScreen(navController)
        }
        composable(Destination.HomeWorkSubjects.route,
            enterTransition = { fadeIn()+ slideInVertically  (initialOffsetY = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutVertically  (targetOffsetY = {-1000}, animationSpec = tween(700))}
            ){backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId")
            HomeWorkSubjects(subjectId,navController)
        }
        composable(Destination.Notifications.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700))}){
            Notification(navController)
        }
        composable(Destination.Lessons.route,
            enterTransition = { fadeIn()+ slideInHorizontally (initialOffsetX = {1000}, animationSpec = tween(700)) },
            exitTransition = { fadeOut()+ slideOutHorizontally  (targetOffsetX = {-1000}, animationSpec = tween(700))})
        {backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")
            Lesson(lessonId,navController)
        }
    }
}
