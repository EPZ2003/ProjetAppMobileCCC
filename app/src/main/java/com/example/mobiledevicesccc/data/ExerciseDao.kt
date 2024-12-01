package com.example.mobiledevicesccc.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ExerciseDao {
    @Query ("SELECT * FROM Exercise")
    fun getAllExercise(): Flow<List<Exercise>>

    @Query("SELECT * FROM Exercise WHERE id = :id")
    fun getExerciseById(id: Int): Flow<Exercise>

    // Insertion d'un exercice
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExercise(exercise: Exercise)

    @Update
    suspend fun updateExercise(exercise: Exercise)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)

}