package com.example.mobiledevicesccc.modelviepackage

import androidx.lifecycle.ViewModel
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDao
import kotlinx.coroutines.flow.Flow

class ViewModelGetId (private val exerciseDao: ExerciseDao) : ViewModel()  {
    fun getchEntityById(id: Int) : Flow<Exercise> {
        return exerciseDao.getExerciseById(id)
    }
}