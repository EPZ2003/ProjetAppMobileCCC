//package com.example.mobiledevicesccc.pages
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Spinner
//import android.widget.TextView
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import com.example.mobiledevicesccc.R
//
//class UpdateExercice : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId", "WrongViewCast", "SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_update_exercice)
//
//        // Récupérer les données de l'Intent
//        val exerciseId = intent.getIntExtra("EXERCISE_ID", -1)
//        val exerciseName = intent.getStringExtra("EXERCISE_NAME")
//        val exerciseRounds = intent.getIntExtra("EXERCISE_ROUNDS", 0)
//        var exerciseRestTime = intent.getIntExtra("EXERCISE_REST_TIME", 0) //en miliseconde
//        var exercisemin = exerciseRestTime / 60000
//        var exercisesec = exerciseRestTime % 60000
//
//        //Nouvelle varaiable
//        val spinner = findViewById<Spinner>(R.id.attributeSpinner)
//        val btnUEToWP = findViewById<Button>(R.id.btnUEToWP)
//        val btnSubround = findViewById<Button>(R.id.submitRoundButton)
//        val btnSubTime = findViewById<Button>(R.id.submitTimeButton)
//        var roundtext = findViewById<EditText>(R.id.roundInput) // //zone de texte pour les round
//        var mininput = findViewById<EditText>(R.id.MinInput) //zone de texte pour les minutes
//        var sinput = findViewById<EditText>(R.id.SInput) //zone de texte pour les secondes
//        var lblmin_s = findViewById<TextView>(R.id.lblmin_s)// affichage de min et s
//
//        //Affichage de l'exercice selectionné
//        var exercicetext = findViewById<TextView>(R.id.exercise)
//        exercicetext.text = "Ex "+exerciseId+": "+exerciseName+"("+exerciseRounds+","+exercisemin+"m"+exercisesec+"s)"
//
//        btnUEToWP.setOnClickListener {
//            val intent = Intent(this, WorkoutProgram::class.java)
//            startActivity(intent)
//        }
//
//        btnSubround.setOnClickListener{
//            findViewById<EditText>(R.id.roundText).setText(roundtext.toString())
//            exercicetext.text = "Ex "+exerciseId+": "+exerciseName+"("+roundtext.toString()+","+exercisemin+"m"+exercisesec+"s)"
//        }
//
//        btnUEToWP.setOnClickListener{
//            findViewById<EditText>(R.id.restTimeText).setText(((sinput.toString()).toInt()+(mininput.toString()).toInt()).toString())
//
//        }
//
//
//        // Liste des attributs pour le Spinner
//        val attributes = listOf("Select Attribute", "Round", "Rest Time")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, attributes)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = adapter
//
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            @SuppressLint("SetTextI18n")
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
//            ) {
//                when (attributes[position]) {
//                    "Round" -> {
//                        roundtext.visibility = View.VISIBLE
//                        btnSubround.visibility = View.VISIBLE
//                        btnSubTime.visibility = View.INVISIBLE
//                        mininput.visibility = View.INVISIBLE
//                        sinput.visibility = View.INVISIBLE
//                        lblmin_s.visibility = View.INVISIBLE
//                        if(!roundtext.text.isNullOrEmpty())
//                        {
//                        }
//
//                    }
//                    "Rest Time" -> {
//                        btnSubTime.visibility = View.VISIBLE
//                        mininput.visibility = View.VISIBLE
//                        sinput.visibility = View.VISIBLE
//                        lblmin_s.visibility = View.VISIBLE
//                        roundtext.visibility = View.INVISIBLE
//                        btnSubround.visibility = View.INVISIBLE
//                        if(!mininput.text.isNullOrEmpty() && !sinput.text.isNullOrEmpty())
//                        {
//                        }
//                    }
//                    else ->
//                        {
//                            btnSubTime.visibility = View.INVISIBLE
//                            mininput.visibility = View.INVISIBLE
//                            sinput.visibility = View.INVISIBLE
//                            lblmin_s.visibility = View.INVISIBLE
//                            roundtext.visibility = View.INVISIBLE
//                            btnSubround.visibility = View.INVISIBLE
//                        }
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Rien à faire ici
//            }
//        }
//    }
//}
////TODO DOIT FINIR LES DEUX PAGES

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import com.example.mobiledevicesccc.data.ExerciseDatabase
import kotlinx.coroutines.flow.collect

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
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
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
            Text(text = "Rounds: ${exercise.round}", fontSize = 18.sp)
            Text(text = "Time: ${exercise.time}", fontSize = 18.sp)
            Text(text = "Type: ${exercise.typeExercise}", fontSize = 18.sp)
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
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Submit")
            }
            // Bouton Supprimer
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Appeler la fonction de suppression
                    viewModel.deleteExercise(exercise)
                    context.startActivity(Intent(context, WorkoutPlanning::class.java))
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Delete")
            }
        }

        // Boutons Retour et Home en bas
        Spacer(modifier = Modifier.weight(1f)) // Pousse les boutons en bas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { val intent = Intent(context, WorkoutProgram::class.java)
                intent.putExtra("KeyBtn","4")
                context.startActivity(intent)
            }) {
                Text(text = "Retour")
            }
            Button(onClick = { context.startActivity(Intent(context, HomePage::class.java)) }) {
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
        Button(onClick = { expanded = true }) {
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



