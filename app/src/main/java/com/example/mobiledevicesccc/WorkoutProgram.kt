package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WorkoutProgram : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_workout_program)

        val btnWPlanning = findViewById<Button>(R.id.btnWPlanning)

        //Change the value of txtchooseWP by the passing button
        val txtChooseWP = findViewById<TextView>(R.id.txtchooseWP)
        val receiverTxt = intent.getStringExtra("KeyBtn")
        txtChooseWP.text = receiverTxt

        btnWPlanning.setOnClickListener {
            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }


    }
}