package com.example.mobiledevicesccc.pages
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ExerciseList
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import kotlinx.coroutines.flow.Flow
import androidx.compose.runtime.*



class WorkoutProgram : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val index = intent.getStringExtra("KeyBtn")
        val db = Room.databaseBuilder(applicationContext, ExerciseDatabase::class.java, "Exercise_database").build()
        val exerciseDao = db.ExerciseDao()
        val exercise: Flow<List<Exercise>> = exerciseDao.getAllExercise()
        val viewModel = ViewModelGetAllData(exerciseDao)
        setContent {

            if (index != null) {
                WorkingProgramScreen(this,exercise,index)
            }else{
                WorkingProgramScreen(this,exercise,"1")
            }

        }
    }
}

@Composable
fun WorkingProgramScreen(context: Context, items: Flow<List<Exercise>>, number: String) {
    // Collecter les données de la Flow
    val exercises by items.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Section 1 : Titre
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "WorkingProgram",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(20.dp)) // Espacement entre le titre et la flèche
            Text(
                text = "→ $number",
                fontSize = 24.sp
            )
        }

        // Section 2 : Liste des exercices
        Box(
            modifier = Modifier
                .weight(1f) // Utilise tout l'espace disponible entre le titre et les boutons
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            if (exercises.isEmpty()) {
                Text(
                    text = "No exercises available",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            } else {
                // Remplacer la Column par LazyColumn pour permettre le défilement
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Espacement entre les éléments
                ) {
                    items(exercises) { exercise ->
                        ListItem(
                            exercise = exercise,
                            onUpdateClick = {
                                val intent = Intent(context, UpdateExercice::class.java).apply {
                                    putExtra("exerciseId", exercise.id)
                                    putExtra("exerciseName", exercise.name)
                                    putExtra("exerciseRound", exercise.round)
                                    putExtra("exerciseTime", exercise.time)
                                    putExtra("exerciseType", exercise.typeExercise)
                                }
                                context.startActivity(intent)
                            }
                        )
                    }
                }
            }
        }

        // Section 3 : Boutons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Button(onClick = { context.startActivity(Intent(context, AddExercise::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366), contentColor = Color.White)  // Couleur du texte
                ) {
                Text(text = "Add")
            }
            Button(onClick = { context.startActivity(Intent(context, HomePage::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366),contentColor = Color.White)
                ) {
                Text(text = "Home")
            }
            Button(onClick = { context.startActivity(Intent(context, WorkoutPlanning::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366), contentColor = Color.White)
            ) {
                Text(text = "Back")
            }
        }
    }
}


@Composable
fun ListItem(exercise: Exercise, onUpdateClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f) // Équilibrer l'espace entre le texte et le bouton
            ) {
                Text(text = "Name: ${exercise.name}", fontSize = 18.sp)
                Text(text = "Rounds: ${exercise.round}", fontSize = 14.sp)
                Text(text = "Time: ${exercise.time}", fontSize = 14.sp)
                Text(text = "Type: ${exercise.typeExercise}", fontSize = 14.sp)
            }
            Button(
                onClick = onUpdateClick,
                modifier = Modifier.align(Alignment.CenterVertically),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White),
            ) {
                Text(text = "Update")
            }
        }
    }
}
