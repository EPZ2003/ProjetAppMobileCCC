package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RoundInput : AppCompatActivity()
    {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_round_input)

            val btnGoToWP = findViewById<Button>(R.id.goToWorkoutPlanning)
            //val btnGoToCP = findViewById<Button>(R.id.goToCurrentProgram)
            //val btnGoToAE = findViewById<Button>(R.id.goToAddExercises)

            btnGoToWP.setOnClickListener {

                val intent = Intent(this,WorkoutPlanning::class.java)
                startActivity(intent)
            }
/*
            btnGoToCP.setOnClickListener {

                val intent = Intent(this,CurrentWorkout::class.java)
                startActivity(intent)
            }

            btnGoToWP.setOnClickListener {

                val intent = Intent(this,AddExercises::class.java)
                startActivity(intent)
            }

 */
        }
    }