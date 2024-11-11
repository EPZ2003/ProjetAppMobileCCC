package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.Duration

class RestTime : AppCompatActivity() {

   lateinit var timerTextView : TextView //minuteur
   lateinit var btnRTP : Button //boutton pause
   lateinit var titleRT : TextView //texte (temps restant/pause)


    private var countdownTimer: CountDownTimer? = null
    private var timeLeftInMillis: Long = 70000  // 1 minute 10 seconde en millisecondes (60000=1 min)
    private var timeRemaining = timeLeftInMillis //permet de garder le temps lorsqu'on fait pause. Pas automatique
    private var isTimerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rest_time)

        btnRTP = findViewById(R.id.btnRTP)
        val btnRTW = findViewById<Button>(R.id.btnRTW)
        val btnRTHP = findViewById<Button>(R.id.btnRTHP)
        titleRT = findViewById(R.id.titleRT)
        timerTextView = findViewById(R.id.timer)

        val shouldStartTimer = intent.getBooleanExtra("start_timer", false)
        if (shouldStartTimer) {
            startTimer(timeRemaining)
        }


            btnRTP.setOnClickListener {
                if (!isTimerRunning) {
                    // Si le timer est en pause, reprendre le timer
                    pauseTimer()
                } else {
                    // Sinon, mettre en pause le timer
                    resumeTimer()
                }
                updateButtons()
            }
            btnRTW.setOnClickListener {

                val intent = Intent(this, Workout::class.java)
                startActivity(intent)
            }
            btnRTHP.setOnClickListener {

                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
        }

    private fun startTimer(duree: Long) {
        countdownTimer = object : CountDownTimer(duree, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeRemaining = millisUntilFinished
                // Mettre à jour l'affichage du temps restant
                val secondsLeft = millisUntilFinished / 1000
                updateTimerText(millisUntilFinished)
            }

            override fun onFinish() {
                timerTextView.text = "Terminé !"
                redirectToWorkout()
            }
        }.start()
    }

    private fun resumeTimer() {
        titleRT.text = "Rest Time"
        // Redémarrer le timer avec le temps restant
        startTimer(timeRemaining)
        isTimerRunning = false;
    }

    private fun updateTimerText(timeLeftInMillis: Long){
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        timerTextView.text = String.format("%02d:%02d", minutes, seconds)
    }

    private fun pauseTimer() {
        titleRT.text = "Pause"
        isTimerRunning = true
        // Annuler le timer actuel pour le mettre en pause
        countdownTimer?.cancel()
    }

    private fun redirectToWorkout() {
        val intent = Intent(this, Workout::class.java)
        startActivity(intent)
    }

    private fun updateButtons() {
        if (btnRTP.text == "Pause")
        {
            btnRTP.text = "Démarrer"
        } else
        {
            btnRTP.text = "Pause"
        }
    }
}