package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpdateExercice : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_exercice)
        val btnUEToWP = findViewById<Button>(R.id.btnUEToWP)
        btnUEToWP.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            startActivity(intent)
        }
    }
}
//TODO DOIT FINIR LES DEUX PAGES
