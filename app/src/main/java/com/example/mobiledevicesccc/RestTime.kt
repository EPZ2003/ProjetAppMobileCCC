package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.ui.platform.LocalContext

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.delay

class RestTime : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rest_time)
        setContent {
            Text(
                text = "Timer Screen Test",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
        val btnRTP = findViewById<Button>(R.id.btnRTP)
        val btnRTW = findViewById<Button>(R.id.btnRTW)
        val btnRTHP = findViewById<Button>(R.id.btnRTHP)

        btnRTP.setOnClickListener {

            val intent = Intent(this,Pause::class.java)
            startActivity(intent)
        }
        btnRTW.setOnClickListener {

            val intent = Intent(this,Workout::class.java)
            startActivity(intent)
        }
        btnRTHP.setOnClickListener {

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)}

            val etMinutes = findViewById<TextInputEditText>(R.id.InputMinute)
            val etSeconds = findViewById<TextInputEditText>(R.id.InputSecond)

            val minute = etMinutes.text.toString().toIntOrNull() ?: 5
            val second = etSeconds.text.toString().toIntOrNull() ?: 5

            val composeView = findViewById<ComposeView>(R.id.composeView)

        @Composable
        fun RestTimerScreen(
            restTimeMinutes: Int,
            restTimeSeconds: Int,
            onWorkoutNavigate: () -> Unit
        ) {
            val totalTimeInSeconds = restTimeMinutes * 60 + restTimeSeconds
            var remainingTime by remember { mutableStateOf(totalTimeInSeconds) }

            LaunchedEffect(Unit) {
                while (remainingTime > 0) {
                    delay(1000L) // Attendre une seconde
                    remainingTime -= 1
                }
                onWorkoutNavigate() // Naviguer ou fermer l'écran après la fin du timer
            }

            Text(
                text = String.format(
                    "%02d:%02d",
                    remainingTime / 60,
                    remainingTime % 60
                ),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }

        }}




