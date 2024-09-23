package com.example.eduguideapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eduguideapp.Navigation.Destination
import com.example.eduguideapp.data.BottomSheetContent
import com.example.eduguideapp.data.BottomSheetData
import com.example.eduguideapp.data.BottomSheetRepo
import com.example.eduguideapp.data.NotificationCard
import com.example.eduguideapp.data.NotificationList
import com.example.eduguideapp.data.NotificationsData
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notification(navController: NavController,data: List<NotificationsData> = NotificationList.notifications) {
    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val coroutineScope = rememberCoroutineScope()

    var selectedSheetData by remember {
        mutableStateOf<BottomSheetData?>(null)
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            selectedSheetData?.let {
                BottomSheetContent(navController,data = it) // Pass the selected sheet data to BottomSheet
            }
        },
        sheetPeekHeight = 0.dp // Initially hidden
    ) {
        Column(
            modifier = Modifier.padding(top = 50.dp)
        ) {
            // Header
            Row {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp, top = 8.dp)
                        .size(40.dp)
                        .background(
                            Color.White
                        )
                        .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                        .clickable {
                            navController.navigate(Destination.HomePage.route)
                        }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = "Notifications",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp, bottom = 30.dp)
                )
            }

            // Notification List
            LazyColumn {
                items(data) { notification ->
                    NotificationCard(data = notification) {
                        // When a card is clicked, set the selected bottom sheet data and show the sheet
                        selectedSheetData = BottomSheetRepo.getId(notification.id) // Assuming the ID matches
                        coroutineScope.launch {
                            sheetState.expand()
                        }
                    }
                }
            }
        }
    }
}