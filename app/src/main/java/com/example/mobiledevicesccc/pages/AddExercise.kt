package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room

import com.example.mobiledevicesccc.R
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import kotlinx.coroutines.flow.Flow
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


class AddExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exerciseIndex = intent.getStringExtra("KeyBtn")
        val db = Room.databaseBuilder(applicationContext, ExerciseDatabase::class.java, "Exercise_database").build()
        val exerciseDao = db.ExerciseDao()
        val exercise: Flow<List<com.example.mobiledevicesccc.data.Exercise>> =
            exerciseDao.getAllExercise()
        val viewModel = ViewModelGetAllData(exerciseDao)
        setContent {
            if (exerciseIndex != null) {
                AddExerciseScreen(viewModel,this,exerciseIndex)
            }else
            {
                AddExerciseScreen(viewModel,this,"1")
            }
        }
    }
}



@Composable
fun AddExerciseScreen(viewModel: ViewModelGetAllData, context: Context,index : String) {
    var name by remember { mutableStateOf("") }
    var round by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) } // Pour afficher ou cacher le popup

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Titre en haut de l'écran
        Text(
            text = "Add Exercise",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 16.dp),
            style = MaterialTheme.typography.h5
        )

        // Contenu centré au milieu de l'écran
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        ) {
            // Champ pour le nom
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Exercise Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Champ pour les rounds
            TextField(
                value = round,
                onValueChange = { round = it },
                label = { Text("Rounds") },
                modifier = Modifier.fillMaxWidth()
            )

            // Champ pour le temps
            TextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time") },
                modifier = Modifier.fillMaxWidth()
            )

            // Champ pour le type d'exercice
            TextField(
                value = type,
                onValueChange = { type = it },
                label = { Text("Type") },
                modifier = Modifier.fillMaxWidth()
            )

            // Afficher le message d'erreur s'il y en a un
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = androidx.compose.material3.MaterialTheme.colorScheme.error,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            // Bouton pour ajouter l'exercice
            Button(
                onClick = {
                    // Validation des champs
                    when {
                        name.isEmpty() -> errorMessage = "Name is required."
                        round.isEmpty() || round.toIntOrNull() == null -> errorMessage = "Rounds must be a valid number."
                        time.isEmpty() || time.toIntOrNull() == null -> errorMessage = "Time must be a valid number."
                        type.isEmpty() -> errorMessage = "Type is required."
                        else -> {
                            // Si tout est valide, on crée l'exercice
                            val exercise = com.example.mobiledevicesccc.data.Exercise(
                                id = 0, // L'ID sera généré automatiquement par la base de données
                                name = name,
                                round = round.toInt(),
                                time = time,
                                typeExercise = type
                            )

                            // Insertion de l'exercice dans la base de données
                            viewModel.insertExercise(exercise)

                            // Afficher le popup
                            showDialog = true

                            // Réinitialiser les champs et le message d'erreur
                            name = ""
                            round = ""
                            time = ""
                            type = ""
                            errorMessage = ""
                        }
                    }
                },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow,contentColor = Color.White)
            ) {
                Text(text = "Add Exercise")
            }
        }

        // Boutons Home et Retour en bas de l'écran
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                context.startActivity(Intent(context, HomePage::class.java))
            },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(Color(0xFF003366), contentColor = Color.White)
            ) {
                Text(text = "Home")
            }

            Button(onClick = { val intent = Intent(context, WorkoutProgram::class.java)
                intent.putExtra("KeyBtn",index)
                context.startActivity(intent)
            },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(Color(0xFF003366), contentColor = Color.White)
            ) {
                Text(text = "Retour")
            }
        }
    }

    // Popup d'ajout réussi
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false // Fermer le popup
                    }
                ) {
                    Text("OK")
                }
            },
            title = { Text("Success") },
            text = { Text("Exercise added successfully!") }
        )
    }
}

