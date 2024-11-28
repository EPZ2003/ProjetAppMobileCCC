package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevicesccc.R

class AddExercise : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_exercise)

        val txtChoose = findViewById<TextView>(R.id.txtChoose)
        val receiverTxt = intent.getStringExtra("KeyBtnToADD")
        txtChoose.text = receiverTxt


        val btnRoudInput = findViewById<Button>(R.id.btnRoudInput)
        val btnRTI = findViewById<Button>(R.id.btnRTI)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnAEHP = findViewById<Button>(R.id.btnAEHP)
        val btnAEWP = findViewById<Button>(R.id.btnAEWP)

        btnRoudInput.setOnClickListener {

            val intent = Intent(this, RoundInput::class.java)
            startActivity(intent)
        }
        btnRTI.setOnClickListener {


            val intent = Intent(this, RestTimeInput::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            intent.putExtra("KeyBtn",receiverTxt)
            startActivity(intent)
        }
        btnAEHP.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        btnAEWP.setOnClickListener {
            val intent = Intent(this, WorkoutPlanning::class.java)
            startActivity(intent)
        }
    }
}