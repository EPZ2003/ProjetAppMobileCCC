package com.example.mobiledevicesccc.EachPagefunctions

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobiledevicesccc.DisplayBtn
import com.example.mobiledevicesccc.RestTime
import com.example.mobiledevicesccc.Title
import com.example.mobiledevicesccc.modelviepackage.ExerciseScreen
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId
import com.example.mobiledevicesccc.navButton.StartNewActictivty

@Composable
fun WorkoutDisplaying(viewModel: ViewModelGetId,id: Int,context: Context){

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Title()

        ExerciseScreen(viewModel,id,"Passed")
        ExerciseScreen(viewModel,id + 1,"NULL")
        ExerciseScreen(viewModel,id + 2,"Coming after")
        Text(" ")
        DisplayBtn(context)
    }

    StartNewActictivty(context, activityClass = RestTime::class.java)

}