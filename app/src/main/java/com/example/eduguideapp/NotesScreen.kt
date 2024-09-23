package com.example.eduguideapp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.data.SubjectCard
import com.example.eduguideapp.data.SubjectData
import com.example.eduguideapp.data.SubjectDataRepo
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesScreen(navController: NavController,data: List<SubjectData> = SubjectDataRepo.subdatas){
    var search2 by remember {
        mutableStateOf("")
    }
    Scaffold(

    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Row {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Subjects",
                        fontSize = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(end = 80.dp)
                    )
                }
                TextButton(onClick = { navController.navigate(Destination.HomeWork.route) }) {
                    Text(
                        text = "HomeWork",
                        fontSize = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                }
            }
            TextField(value = search2, onValueChange = { search2 = it }, modifier = Modifier
                .padding(15.dp)
                .clip(
                    RoundedCornerShape(25.dp)
                )
                .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                label = { Text(text = "Search", fontSize = 20.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(30.dp)
                    )
                }
            )
            LazyColumn(
                contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding()),
                modifier = Modifier.fillMaxSize()
            ) {

                itemsIndexed(data) { index,subtasks ->
                    var isvisible by remember {
                        mutableStateOf(false)
                    }
                    LaunchedEffect(Unit) {
                        delay(index *80L)
                        isvisible = true
                    }
                    AnimatedVisibility(visible = isvisible, enter = slideInVertically (initialOffsetY = {it})+ fadeIn(), exit = slideOutVertically (targetOffsetY = {it})+ fadeOut() ) {
                        SubjectCard(navController,data = subtasks)
                    }

                }
            }
        }

    }
}
