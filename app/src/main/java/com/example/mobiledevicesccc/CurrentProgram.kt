package com.example.mobiledevicesccc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CurrentProgram : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val origin = intent.getStringExtra("origin")
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
            })

    }}

    @Composable
    fun CurrentProgramScreen(onBackClick: () -> Unit) {
        // Données fictives
        val listName = listOf("Exercice 1", "Exercice 2", "Exercice 3")
        val listRounds = listOf("5", "6", "2")
        val listMinuteRest = listOf("1", "0", "4")
        val listSecondRest = listOf("30", "20", "00")

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

            // Itération pour chaque exercice
            listName.forEachIndexed { index, name ->
                val rounds = listRounds[index]
                val minutes = listMinuteRest[index]
                val seconds = listSecondRest[index]

                // Affichage d'un exercice
                ExerciseItem(
                    name = name,
                    rounds = rounds,
                    minutes = minutes,
                    seconds = seconds
                )
            }
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

    @Composable
    fun ExerciseItem(name: String, rounds: String, minutes: String, seconds: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Nom de l'exercice
            Text(
                text = name,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f) // Occupe l'espace restant
            )

            // Nombre de rounds
            Text(
                text = "$rounds rounds",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 16.dp)
            )

            // Temps de repos
            Text(
                text = "$minutes:$seconds",
                fontSize = 16.sp
            )
        }
}}