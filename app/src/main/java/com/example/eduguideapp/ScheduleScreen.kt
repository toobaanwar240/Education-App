package com.example.eduguideapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.data.SmallCard
import com.example.eduguideapp.data.SmallData
import com.example.eduguideapp.ui.theme.EduGuide
import com.example.eduguideapp.ui.theme.Typography2
import java.time.DayOfWeek


import java.time.LocalDate

import java.time.format.TextStyle
import java.util.Locale


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
    @Preview(showBackground = true)
@Composable

fun ScheduleScreenComp() {

    Scaffold {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {

                ScheduleScreen()

        }

    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleScreen() {
    var showDatePickerDialog by remember {
        mutableStateOf(false)
    }
    var selecteddate by remember {
        mutableStateOf(LocalDate.now())
    }
    val currentWeek = getCurrentWeek()
    val scrollstate = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row {

            Text(text = "Schedule", style = Typography2.displayLarge, fontSize = 30.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { })
        }
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()

                .background(EduGuide.lightGrey),

            ) {
            Column {
                Row {
                    Text(
                        text = "This Week",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 8.dp, top = 10.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Expand",
                        modifier = Modifier
                            .padding(bottom = 10.dp, end = 10.dp, top = 10.dp)
                            .size(30.dp)
                            .clickable { showDatePickerDialog = true },
                        tint = Color.Black
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                ) {
                    // Display current week (e.g., Mon - Sun)
                    currentWeek.forEach { day ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Text(
                                text = day.dayOfWeek.getDisplayName(
                                    TextStyle.SHORT,
                                    Locale.getDefault()
                                ),
                                fontSize = 16.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(if (day == selecteddate) EduGuide.lightblue else Color.Transparent)
                                    .clickable { selecteddate = day },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = day.dayOfMonth.toString(),
                                    color = if (day == selecteddate) Color.Black else Color.Black, // Change text color based on selection
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }

                }

            }
        }

        // Full Calendar Dialog when expanded
        if (showDatePickerDialog) {
            DatePickerModal(
                onDateSelected = { selectedMillis ->
                    selecteddate = selectedMillis?.let {
                        LocalDate.ofEpochDay(it / (1000 * 60 * 60 * 24))
                    } ?: LocalDate.now()
                    showDatePickerDialog = false
                },
                onDismiss = { showDatePickerDialog = false }
            )
        }
        Column (
            modifier = Modifier.verticalScroll(scrollstate)
        ){


            SmallCard(
                data = SmallData(
                    20.dp,
                    "8:00 am",
                    "Basic Mathematics",
                    "8:00am - 8:45am",
                    EduGuide.pastelPurple
                )
            )
            Row {
                Text(
                    text = "9:00 am", fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
                Text(
                    text = "- - - - - - - - - - - - - - - - - - - - - - - -  ",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
            }
            SmallCard(
                data = SmallData(
                    27.dp,
                    "10:00 am",
                    "English Grammar",
                    "10:00am - 10:45am",
                    EduGuide.pastelSeaGreenLight
                )
            )
            Row {
                Text(
                    text = "9:00 am", fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
                Text(
                    text = "- - - - - - - - - - - - - - - - - - - - - - - -  ",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
            }
            SmallCard(
                data = SmallData(
                    30.dp,
                    "12:00 am",
                    "Science",
                    "12:00am - 12:45am",
                    EduGuide.lightblue
                )
            )
            SmallCard(
                data = SmallData(
                    30.dp,
                    "1:00 am",
                    "World History",
                    "1:00am - 1:45am",
                    EduGuide.PastelYellow
                )
            )
            Row {
                Text(
                    text = "2:00 am", fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
                Text(
                    text = "- - - - - - - - - - - - - - - - - - - - - - - -  ",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 5.dp)
                )
            }
            SmallCard(
                data = SmallData(
                    30.dp,
                    "3:00 am",
                    "BasketBall",
                    "3:00am - 3:45am",
                    EduGuide.pastelPinkLight
                )
            )

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentWeek(): List<LocalDate> {
    val today = LocalDate.now()
    val startOfWeek = today.with(DayOfWeek.MONDAY)
    return List(7) { startOfWeek.plusDays(it.toLong()) }
}