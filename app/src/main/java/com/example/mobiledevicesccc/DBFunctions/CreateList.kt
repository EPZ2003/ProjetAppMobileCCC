package com.example.mobiledevicesccc.DBFunctions

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import kotlinx.coroutines.flow.Flow
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class TrackingWorkout {
    companion object {
        var begin = 1
        var tracking = 1 // TODO LINK WHEN YOU CLICK INTO THE REST TIME BUTTON
    }
}
@Composable
fun CreateList (exerciseFlow: Flow<List<Exercise>>) {

    var status = "tesdt"

    val exercises by exerciseFlow.collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        items(exercises) { exercise ->
            if (exercise.id in TrackingWorkout.tracking..TrackingWorkout.tracking+3 - 1){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth() // Make the row fill the available width
                            .background(Color.Magenta)
                            .align(Alignment.End),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(fontSize = 72.sp,
                            text =exercise.name)
                    }
                    Row (
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Text(exercise.time)
                    }
                }
            }

        }
    }

}

