package com.example.mobiledevicesccc.modelviepackage

import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.sp
import com.example.mobiledevicesccc.data.Exercise

@Composable
fun CurrentPageListExercise(viewModelGetAllData: ViewModelGetAllData){
    val exerciseList by viewModelGetAllData.getAllData().collectAsState(initial = emptyList())
    if (exerciseList != null) {
        ExerciseItem(exerciseList)
    }else {
        Text("")
    }
}
@Composable
fun ExerciseItem(exerciseList: List<Exercise>)  {
    LazyColumn(

    ) {
        items(exerciseList) { exercise ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Nom de l'exercice
                androidx.compose.material.Text(
                    text = exercise.name,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f) // Occupe l'espace restant
                )

                // Nombre de rounds
                androidx.compose.material.Text(
                    text = "${exercise.round} rounds",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )

                // Temps de repos
                androidx.compose.material.Text(
                    text = "${exercise.time} seconds",
                    fontSize = 16.sp
                )
            }
        }
    }
}