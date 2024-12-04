package com.example.mobiledevicesccc.pages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import com.example.mobiledevicesccc.data.ExerciseDatabase


class UpdateExercice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Récupérer l'exercice à partir de l'Intent
        val exerciseId = intent.getIntExtra("exerciseId", -1)
        val exerciseName = intent.getStringExtra("exerciseName") ?: "Unknown"
        val exerciseRound = intent.getIntExtra("exerciseRound", 0)
        val exerciseTime = intent.getStringExtra("exerciseTime") ?: "0s"
        val exerciseType = intent.getStringExtra("exerciseType") ?: "Unknown"

        // Initialiser la base de données et le ViewModel
        val db = ExerciseDatabase.getDatabase(applicationContext)
        val exerciseDao = db.ExerciseDao()
        val viewModel = ViewModelGetAllData(exerciseDao)

        val exercise = Exercise(
            id = exerciseId,
            name = exerciseName,
            round = exerciseRound,
            time = exerciseTime,
            typeExercise = exerciseType
        )

        setContent {
            UpdateExerciseScreen(
                context = this,
                exercise = exercise,
                viewModel = viewModel
            )
        }
    }
}


@Composable
fun UpdateExerciseScreen(context: Context, exercise: Exercise, viewModel: ViewModelGetAllData) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var newValue by remember { mutableStateOf(TextFieldValue("")) }
    var showTextField by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Titre
        Text(
            text = "Update Exercise",
            fontSize = 34.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        // Détails de l'exercice à modifier
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Name: ${exercise.name}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Rounds: ${exercise.round}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Time: ${exercise.time}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Type: ${exercise.typeExercise}", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Dropdown (Spinner) pour choisir ce qu'on modifie
        Text(text = "Choose what to update:", fontSize = 18.sp)
        DropdownMenu(selectedOption = selectedOption) { option ->
            selectedOption = option
            showTextField = true // Affiche la zone de texte après le choix
            isError = false // Réinitialiser l'erreur
        }

        // Zone de texte pour entrer la nouvelle valeur
        if (showTextField && selectedOption != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Enter new ${selectedOption?.lowercase()}:",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            BasicTextField(
                value = newValue,
                onValueChange = {
                    newValue = it
                    isError = false // Réinitialiser l'erreur quand l'utilisateur tape
                },
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 24.sp, // Augmenter la taille du texte
                    textAlign = TextAlign.Center // Centrage horizontal du texte
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp)
                    .border(1.dp, if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 8.dp)
            )

            // Message d'erreur
            if (isError) {
                Text(
                    text = "Please enter a valid integer value.",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Button(
                onClick = {
                    // Validation de l'entrée
                    val input = newValue.text
                    if (selectedOption == "Round" && input.toIntOrNull() == null) {
                        isError = true // Affiche l'erreur si l'entrée n'est pas un entier
                    }
                    else if (selectedOption == "Time" && input.toIntOrNull() == null)
                    {
                        isError = true // Affiche l'erreur si l'entrée n'est pas un entier
                    }
                    else {
                        isError = false
                        // Logique pour enregistrer les changements
                        // Mettre à jour l'exercice dans la base de données via ViewModel
                        val updatedExercise = when (selectedOption) {
                            "Round" -> exercise.copy(round = input.toIntOrNull() ?: exercise.round)
                            "Time" -> exercise.copy(time = input)
                            else -> exercise
                        }

                        viewModel.updateExercise(updatedExercise)
                        context.startActivity(Intent(context, WorkoutPlanning::class.java))
                    }
                },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black,contentColor = Color.White)
            ) {
                Text(text = "Submit")
            }
        }
        // Bouton Supprimer
        Spacer(modifier = Modifier.height(96.dp))
        Button(
            onClick = {
                // Appeler la fonction de suppression
                viewModel.deleteExercise(exercise)
                context.startActivity(Intent(context, WorkoutPlanning::class.java))
            },
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC143C),contentColor = Color.White)
        ) {
            Text(text = "Delete")
        }

        // Boutons Retour et Home en bas
        Spacer(modifier = Modifier.weight(1f)) // Pousse les boutons en bas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Button(onClick = { context.startActivity(Intent(context, WorkoutProgram::class.java))

                             },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366),contentColor = Color.White)) {
                Text(text = "Retour")
            }
            Button(onClick = { context.startActivity(Intent(context, HomePage::class.java)) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366),contentColor = Color.White)
            ) {
                Text(text = "Home")
            }
        }
    }
}


@Composable
fun DropdownMenu(selectedOption: String?, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Round", "Time")

    Box {
        Button(onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003366),contentColor = Color.White)) {
            Text(text = selectedOption ?: "Select option")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}



