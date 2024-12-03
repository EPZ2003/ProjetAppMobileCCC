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

//4eme etatpe tu cree le compose que tu vas utiliser dans ta page
@Composable
fun HomepageListExercise(viewModelGetAllData: ViewModelGetAllData){
    //5 eme recupere la liste des exercices via le view model creé
    //On le convertit pour qu'on puisse l'utiliser
    val exerciseList by viewModelGetAllData.getAllData().collectAsState(initial = emptyList())
    //On check si jamais
    if (exerciseList != null) {
        //6 Tu crée un compose qui vas utilsier ta liste d'exercices
        ExerciseList(exerciseList)
    }else{
        Text("")
    }

}
//7  Tu définie ton compsoe
@Composable
fun ExerciseList(exerciseList: List<Exercise>) {
    //8 tu crée un lzaycolumn qui vas afficher ta liste d'exercices
    LazyColumn(

    ) {//9 tu instanci le item de ta liste
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
