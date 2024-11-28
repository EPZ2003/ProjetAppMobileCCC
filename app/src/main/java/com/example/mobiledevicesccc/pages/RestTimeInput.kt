package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevicesccc.R

class RestTimeInput : AppCompatActivity()
    {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_rest_time_input)

            val btnGoToWP = findViewById<Button>(R.id.GoToWP)
            val btnGoToCP = findViewById<Button>(R.id.goToCurrentProgram)
            val btnGoToAE = findViewById<Button>(R.id.GoToAE)
            val btnGoBack = findViewById<Button>(R.id.backBtn)

            btnGoToWP.setOnClickListener {

                val intent = Intent(this, WorkoutPlanning::class.java)
                startActivity(intent)
            }

            btnGoToCP.setOnClickListener {

                val intent = Intent(this, CurrentProgram::class.java)
                intent.putExtra("origin","rest_time_input")
                startActivity(intent)
            }

            btnGoToAE.setOnClickListener {

                val intent = Intent(this, AddExercise::class.java)
                startActivity(intent)
            }

        btnGoBack.setOnClickListener {

            val intent = Intent(this, AddExercise::class.java)
            startActivity(intent)
        }


        }
    }