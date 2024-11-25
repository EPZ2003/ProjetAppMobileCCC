package com.example.mobiledevicesccc.DBFunctions

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobiledevicesccc.data.Exercise
import kotlinx.coroutines.flow.Flow


@Composable
fun ExerciseListScreen(exerciseFlow: Flow<List<Exercise>>) {
    // Collect the Flow as a State
    val exercises by exerciseFlow.collectAsState(initial = emptyList())

    // Display the exercises in a LazyColumn
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(exercises) { exercise ->
            Text(
                text = exercise.name + exercise.typeExercise,

                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}