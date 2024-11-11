package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Workout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workout)

        val btnRestTimeW = findViewById<Button>(R.id.btnRestTimeW)
        val btnWHP = findViewById<Button>(R.id.btnWHP)

        btnRestTimeW.setOnClickListener {

            val intent = Intent(this,RestTime::class.java)
            // Ajouter un extra pour indiquer que le timer doit être lancé
            intent.putExtra("start_timer", true)
            startActivity(intent)
        }
        btnWHP.setOnClickListener {

            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }
    }
}