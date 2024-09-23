package com.example.eduguideapp.Navigation
sealed class  Destination(
    val route:String
){
    data object Home : Destination("MainScreen")
    data object Login : Destination("LoginPage")
    data object Sign : Destination("SignInPage")
    data object HomePage : Destination("HomePage")
    data object SchedulePage : Destination("ScheduleScreen")
    data object AuthRoute : Destination("Authentication")
    data object AppRoute : Destination("Application")
    data object Notes : Destination("NotesScreen")
    data object  HomeWork :Destination("HomeWorkScreen")
    data object  HomeWorkSubjects : Destination("HomeWorkSubjects/{subjectId}"){
        fun createRoute(subjectId:String)="HomeWorkSubjects/$subjectId"
    }
    data object Notifications :Destination("Notifications")
    data object Lessons :Destination("LessonMaterials/{lessonId}"){
        fun createRoute(lessonId: String)="LessonMaterials/$lessonId"
    }
}
