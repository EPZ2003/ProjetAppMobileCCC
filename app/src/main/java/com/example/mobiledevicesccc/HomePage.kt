package com.example.mobiledevicesccc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_homepage)

        val btnGoToWP = findViewById<Button>(R.id.unknown)
        val feur = findViewById<Button>(R.id.test)
        btnGoToWP.setOnClickListener {

            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }

        feur.setOnClickListener {

            val far = Intent(this,RoundInput::class.java)
            startActivity(far)
        }
    }
}