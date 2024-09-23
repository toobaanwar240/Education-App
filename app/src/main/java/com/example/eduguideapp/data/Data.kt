package com.example.eduguideapp.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.eduguideapp.R
import com.example.eduguideapp.ui.theme.EduGuide

data class Data(
    val id :Int,
    val name:String,
    val time :String,
    val color: Color,
    @DrawableRes val image :Int,
)

object  DataRepository{
    val datas = listOf(
        Data(
            1,
            "Comedy Show",
            "6:05 PM",
            EduGuide.pastelPinkLight,
            R.drawable.friends
        ),
        Data(
            2,
            "Dance Evening",
        "6:30 PM",
            EduGuide.pastelSeaGreenLight,
        R.drawable.dance
        ),
        Data(
            3,
            "BasketBall Game",
            "9:00 PM",
            EduGuide.pastelPurple,
            R.drawable.basketball
        ),
                Data(
                4,
        "Comedy Show",
        "6:05 PM",
        EduGuide.pastelPinkLight,
        R.drawable.friends
    ),
    Data(
    5,
    "Dance Evening",
    "6:30 PM",
    EduGuide.pastelSeaGreenLight,
    R.drawable.dance
    ),
    Data(
    6,
    "BasketBall Game",
    "9:00 PM",
    EduGuide.pastelPurple,
    R.drawable.basketball
    )
    )
    fun getDates(id:Int)= datas.firstOrNull{it.id == id}
}

data class SmallData(
    val Padding: Dp,
    val time:String,
    val subject :String,
    val timeduration: String,
    val color: Color,
)

data class SubjectData(
    val id :String,
    @DrawableRes val icon2 :Int,
    val subject :String,
    val time :String,
   @DrawableRes val image :Int,
    val tutor :String,
    val color: Color
)

object SubjectDataRepo{
    val subdatas = listOf(
        SubjectData(
            "1",
            R.drawable.calculator2,
            "Basic Mathematics",
            "Today at 8:00 am",
            R.drawable.avatar,
            "Kathryne Murphy",
            EduGuide.lightblue
        ),
        SubjectData(
            "2",
            R.drawable.book2,
            "English Grammar",
            "Today at 11:00 am",
            R.drawable.avatar3,
            "Robert Fox",
            EduGuide.pastelPinkLight
        ),
        SubjectData(
            "3",
            R.drawable.science,
            "Science",
            "Today at 12:00 am",
            R.drawable.sciencetutor,
            "Jane Cooper",
            EduGuide.pastelPurple
        ),
        SubjectData(
            "4",
            R.drawable.history,
            "World History",
            "Tomorrow at 12:00 am",
            R.drawable.sciencetutor,
            "Dylan Fox",
            EduGuide.PastelYellow
        )
    )
    fun getSubjectbyId(Id:String)= subdatas.firstOrNull{it.id == Id }
}

data class HomeWork(
    val id :String,
    @DrawableRes val image :Int,
    val subject: String,
    val time: String,
    val color: Color,
    val text : String
)

object HomeWorkRepo {
    val homeworkdata = listOf(
        HomeWork(
            "1",
            R.drawable.calculator2,
            "Basic Mathematics",
            "45 min",
            EduGuide.lightblue,
            "Done"
        ),
        HomeWork(
            "2",
            R.drawable.book5,
            "English Grammar",
            "45 min",
            EduGuide.pastelPinkLight,
            "To Do"
        ),
        HomeWork(
            "3",
            R.drawable.science,
            "Science",
            "60 min",
            EduGuide.pastelPurple,
            "To Do"
        ),
        HomeWork(
            "4",
            R.drawable.history,
            "World History",
            "55 min",
            EduGuide.PastelYellow,
            "To Do"
        ),
    )
}
data class NotificationsData(
    val id :Int,
    @DrawableRes val icon: Int,
    val subject: String,
    val Text : String,
    val color: Color
)
object NotificationList {
    val notifications = listOf(
        NotificationsData(
            1,
            R.drawable.calculator2,
            "Basic Mathematics",
            "You got D+",
            EduGuide.lightblue
        ),
                NotificationsData(
                    2,
                R.drawable.book2,
        "English Grammar",
        "You got A+",
        EduGuide.pastelPinkLight
    ),
        NotificationsData(
            3,
            R.drawable.science,
            "Science",
            "You got A",
            EduGuide.PastelYellow
        )
    )
}

data class BottomSheetData(
    val id :Int,
    val grade:String,
    val text:String,
    val subject: String,
    @DrawableRes val tutorimage:Int,
    val tutor:String,
    val color: Color
)

object BottomSheetRepo{
    val sheets = listOf(
        BottomSheetData(
            1,
            "D+",
            "Sad,but you need to improve your knowledge",
            "Basic Mathematics",
            R.drawable.avatar,
            "Jane Cooper",
            EduGuide.lightblue
        ),
        BottomSheetData(
            2,
            "A+",
            "Excellent Job! Keep doing the hardwork",
            "English Grammar",
            R.drawable.avatar3,
            "Max Herlin",
            EduGuide.pastelPinkLight
        ),
        BottomSheetData(
            3,
            "A",
            "Excellent Job! Keep doing the hardwork",
            "Science",
            R.drawable.sciencetutor,
            "Claude Hopkins",
            EduGuide.PastelYellow
        )
    )
    fun getId(id: Int)=sheets.firstOrNull{it.id == id}
}

data class LessonData(
    val id: String,
    val subject: String,
    val description:String,
    @DrawableRes val images1: Int,
    @DrawableRes val images2: Int,

)
object LessonRepo{
    val lessons = listOf(
        LessonData(
            "1",
            "Basic Mathematics",
            "Mathematics is the study of numbers, shapes, and patterns, using logic and abstract reasoning to solve problems. It serves as a foundation for many fields, including science, engineering, economics, and technology",
              R.drawable.math1,
            R.drawable.math2
        ),
        LessonData(
            "2",
            "English Grammar",
            "Review and extend your knowledge of the simple present ,past ,perfect tenses and present perfect continous tenses",
            R.drawable.english,
            R.drawable.english2
        ),
        LessonData(
            "3",
            "Science",
            "Science is the systematic study of the natural world through observation, experimentation, and analysis. It aims to understand how the universe works and uncover the laws governing physical, biological, and chemical phenomena",
            R.drawable.science1,
            R.drawable.science2
        ),
        LessonData(
            "4",
            "World History",
            "World history is the study of humanity's past, tracing the development of civilizations, cultures, and societies across time. It explores key events, figures, and movements that have shaped the global landscape",
            R.drawable.history1,
            R.drawable.history2
        ),
    )
    fun getlessonbyId(id: String) = lessons.firstOrNull{it.id == id}
}