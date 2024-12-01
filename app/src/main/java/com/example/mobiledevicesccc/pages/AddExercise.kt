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
import com.example.mobiledevicesccc.Exercise
import com.example.mobiledevicesccc.R
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import kotlinx.coroutines.flow.Flow
import androidx.compose.material3.*
import androidx.compose.runtime.*



class AddExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, ExerciseDatabase::class.java, "Exercise_database").build()
        val exerciseDao = db.ExerciseDao()
        val exercise: Flow<List<com.example.mobiledevicesccc.data.Exercise>> =
            exerciseDao.getAllExercise()
        val viewModel = ViewModelGetAllData(exerciseDao)
        setContent { AddExerciseScreen(viewModel,this) }
    }
}



@Composable
fun AddExerciseScreen(viewModel: ViewModelGetAllData, context: Context) {
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
            fontSize = 24.sp,
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
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
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
            }) {
                Text(text = "Home")
            }

            Button(onClick = {
                context.startActivity(Intent(context, WorkoutProgram::class.java))
            }) {
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






















//        setContentView(R.layout.activity_add_exercise)
    //
    //        val txtChoose = findViewById<TextView>(R.id.txtChoose)
    //        val receiverTxt = intent.getStringExtra("KeyBtnToADD")
    //        txtChoose.text = receiverTxt
    //
    //
    //        val btnRoudInput = findViewById<Button>(R.id.btnRoudInput)
    //        val btnRTI = findViewById<Button>(R.id.btnRTI)
    //        val btnBack = findViewById<Button>(R.id.btnBack)
    //        val btnAEHP = findViewById<Button>(R.id.btnAEHP)
    //        val btnAEWP = findViewById<Button>(R.id.btnAEWP)
    //        val btnadd = findViewById<Button>(R.id.btnADD)
    //        val exospinner = findViewById<Spinner>(R.id.exospinner)
    //        val repspinner = findViewById<Spinner>(R.id.repspinner)
    //
    //        // Liste des attributs pour le Spinner d'exo
    //        val exercice = listOf("Select exo","squat", "Push-ups", "Burpees", "traction", "dips")
    //        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, exercice)
    //        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    //        exospinner.adapter = adapter
    //
    //        // Liste des attributs pour le Spinner de rep
    //        val rep = listOf("Select nb rép","1","2","3","4","5","6","7","8","9","10")
    //        val adapters = ArrayAdapter(this, android.R.layout.simple_spinner_item, rep)
    //        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    //        repspinner.adapter = adapters
    //
    ////        btnRoudInput.setOnClickListener {
    ////            val intent = Intent(this,RoundInput::class.java)
    ////            startActivity(intent)
    ////        }
    ////
    ////        btnRTI.setOnClickListener {
    ////            val intent = Intent(this,RestTimeInput::class.java)
    ////            startActivity(intent)
    ////        }
    //
    //        btnBack.setOnClickListener {
    //            val intent = Intent(this, WorkoutProgram::class.java)
    //            intent.putExtra("KeyBtn",receiverTxt)
    //            startActivity(intent)
    //        }
    //
    ////        btnAEHP.setOnClickListener {
    ////            val intent = Intent(this,HomePage::class.java)
    ////            startActivity(intent)
    ////        }
    ////
    ////        btnAEWP.setOnClickListener {
    ////            val intent = Intent(this,WorkoutPlanning::class.java)
    ////            startActivity(intent)
    ////        }
    //    }
    //}