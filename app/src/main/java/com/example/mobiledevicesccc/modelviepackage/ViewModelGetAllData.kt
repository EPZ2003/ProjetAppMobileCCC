package com.example.mobiledevicesccc.modelviepackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

//3.5 tu cree le view model PAR QUERIES DAO
class ViewModelGetAllData(private val exerciseDao: ExerciseDao) : ViewModel() {

    var sharedValue by mutableStateOf("") // Stocke la valeur partagée
        private set

    fun updateValue(newValue: String) {
        sharedValue = newValue
    }


    fun getAllData(): Flow<List<Exercise>> {
        return exerciseDao.getAllExercise()
    }

    // Insertion d'un exercice
    fun insertExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseDao.insertExercise(exercise)
        }
    }

    // Mettre à jour un exercice
    fun updateExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseDao.updateExercise(exercise)
        }
    }

    // Supprimer un exercice
    fun deleteExercise(exercise: Exercise) {
        viewModelScope.launch {
            exerciseDao.deleteExercise(exercise)  // Appel à la méthode de suppression dans le DAO
        }
    }
}