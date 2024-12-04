package com.example.mobiledevicesccc.pages

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.mobiledevicesccc.EachPagefunctions.CurrentPageDisplaying
import com.example.mobiledevicesccc.EachPagefunctions.HomePageDisplaying
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId
import kotlinx.coroutines.flow.Flow

class CurrentProgram : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val origin = intent.getStringExtra("origin")
        val db = Room.databaseBuilder(
            applicationContext,
            ExerciseDatabase::class.java, "Exercise_database"
        ).build()
        val exerciseDao = db.ExerciseDao()
        val exercise: Flow<List<Exercise>> = exerciseDao.getAllExercise()
        val viewModel = ViewModelGetAllData(exerciseDao)
        setContent {
            CurrentProgramScreen(onBackClick = {
                when (origin) {
                    "round_input" -> {
                        val intent = Intent(this, RoundInput::class.java)
                        startActivity(intent)
                    }

                    "rest_time_page" -> {
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                    }

                    else -> {
                        finish() // Fermer l'écran si aucune information
                    }
                }
            },viewModel)


    }}

    @Composable
    fun CurrentProgramScreen(onBackClick: () -> Unit,viewModel: ViewModelGetAllData) {

        // Conteneur principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Current Program",
                fontSize = 24.sp,  // Définit une taille de texte
                fontWeight = FontWeight.Bold, // Définit un poids (gras)
                modifier = Modifier.padding(bottom = 16.dp)
            )

            CurrentPageDisplaying(viewModel)
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text("\uD83D\uDC41\uFE0F    ")
            }
        }

    }


}