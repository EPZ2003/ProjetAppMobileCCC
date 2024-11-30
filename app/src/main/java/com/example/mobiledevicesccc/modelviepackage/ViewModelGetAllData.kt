package com.example.mobiledevicesccc.modelviepackage

import androidx.lifecycle.ViewModel
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDao
import kotlinx.coroutines.flow.Flow
//3.5 tu cree le view model PAR QUERIES DAO
class ViewModelGetAllData(private val exerciseDao: ExerciseDao) : ViewModel() {
    fun getAllData(): Flow<List<Exercise>> {
        return exerciseDao.getAllExercise()
    }
}