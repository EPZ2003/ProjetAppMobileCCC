package com.example.mobiledevicesccc.pages

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.mobiledevicesccc.DBFunctions.CreateList
import com.example.mobiledevicesccc.EachPagefunctions.WorkoutDisplaying
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId
import com.example.mobiledevicesccc.navButton.GoToPause
import com.example.mobiledevicesccc.navButton.StartNewActictivty
import kotlinx.coroutines.flow.Flow

class Workout : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            ExerciseDatabase::class.java, "Exercise_database"
        ).build()
        val exerciseDao = db.ExerciseDao()
        val viewModel = ViewModelGetId(exerciseDao)
        setContent {
            WorkoutDisplaying(viewModel, TrackingWorkout.tracking,context = this)
        }


    }
}

class TrackingWorkout {
    companion object {
        var begin = 0
        var tracking = 0 // TODO LINK WHEN YOU CLICK INTO THE REST TIME BUTTON
    }
}


@Composable
fun Title (){
        Text(
            text = "Workout",
            fontSize = 56.sp, // Larger font for a title
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
}

@Composable
fun DisplayBtn(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Make the Column take full width
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.Bottom, // Space between buttons
        horizontalAlignment = Alignment.CenterHorizontally,
        // Center-align content
    ) {
        GoToPause(context = context, activityClass = RestTime::class.java)


    }

}

