package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_homepage)

        val btnGoToWP = findViewById<Button>(R.id.goToWorkoutPlanning)
        val btnGO = findViewById<Button>(R.id.btnGO)

        btnGoToWP.setOnClickListener {

            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }
        btnGO.setOnClickListener {

            val intent = Intent(this,Workout::class.java)
            startActivity(intent)
        }
    }
}