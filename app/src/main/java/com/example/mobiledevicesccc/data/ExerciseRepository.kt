package com.example.mobiledevicesccc.data

import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getAllExerciseStream(): Flow<List<Exercise>>

    fun getExerciseStream(id: Int) : Flow<Exercise?>

    suspend fun insertExercise(exercise: Exercise)

    suspend fun deleteExercise(exercise: Exercise)

    suspend fun updateExercise(exercise: Exercise)

}