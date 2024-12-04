package com.example.mobiledevicesccc.modelviepackage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mobiledevicesccc.data.Exercise



@Composable
fun ExerciseScreen(viewModel: ViewModelGetId,id: Int,text: String) {
    val exercise by viewModel.getchEntityById(id).collectAsState(initial = null)
    if (exercise != null) {
        DisplayExercise(exercise!!,text)
    }else{
        Text("")
    }

}
@Composable
fun DisplayExercise(exercise: Exercise, text: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth() // Make the row fill the available width
                .background(Color.Yellow)
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
            if (text == "NULL"){
                Text(exercise.time)

            }else{
                Text(text)
            }

        }
    }
}
