package com.example.mobiledevicesccc.modelviepackage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobiledevicesccc.data.Exercise

@Composable
fun HomepageListExercise(viewModelGetAllData: ViewModelGetAllData){
    val exerciseList by viewModelGetAllData.getAllData().collectAsState(initial = emptyList())
    if (exerciseList != null) {
        ExerciseList(exerciseList)
    }else{
        Text("")
    }

}

@Composable
fun ExerciseList(exerciseList: List<Exercise>) {

    LazyColumn(

    ) {
        items(exerciseList) { exercise ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = exercise.name)
                Text(text = exercise.round.toString() + " rounds")
                Text(text = exercise.time + " seconds")
            }

        }
    }
}
