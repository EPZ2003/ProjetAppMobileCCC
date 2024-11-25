package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pause : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pause)
        val btnPRT = findViewById<Button>(R.id.btnPRT)
        val btnPW = findViewById<Button>(R.id.btnPW)
        val btnPHP = findViewById<Button>(R.id.btnPHP)

        btnPRT.setOnClickListener {

            val intent = Intent(this, R::class.java)
            startActivity(intent)
        }
        btnPW.setOnClickListener {

            val intent = Intent(this,Workout::class.java)
            startActivity(intent)
        }
        btnPHP.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }
    }
}