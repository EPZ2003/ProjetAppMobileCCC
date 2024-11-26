package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddExercise : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
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
        val btnadd = findViewById<Button>(R.id.btnADD)
        val exospinner = findViewById<Spinner>(R.id.exospinner)
        val repspinner = findViewById<Spinner>(R.id.repspinner)

        // Liste des attributs pour le Spinner d'exo
        val exercice = listOf("Select exo","squat", "Push-ups", "Burpees", "traction", "dips")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, exercice)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        exospinner.adapter = adapter

        // Liste des attributs pour le Spinner de rep
        val rep = listOf("Select nb rép","1","2","3","4","5","6","7","8","9","10")
        val adapters = ArrayAdapter(this, android.R.layout.simple_spinner_item, rep)
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        repspinner.adapter = adapters

        btnRoudInput.setOnClickListener {
            val intent = Intent(this,RoundInput::class.java)
            startActivity(intent)
        }

        btnRTI.setOnClickListener {
            val intent = Intent(this,RestTimeInput::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            val intent = Intent(this,WorkoutProgram::class.java)
            intent.putExtra("KeyBtn",receiverTxt)
            startActivity(intent)
        }

        btnAEHP.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }

        btnAEWP.setOnClickListener {
            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }
    }
}