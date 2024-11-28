package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevicesccc.R

class RestTime : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rest_time)

        val btnRTP = findViewById<Button>(R.id.btnRTP)
        val btnRTW = findViewById<Button>(R.id.btnRTW)
        val btnRTHP = findViewById<Button>(R.id.btnRTHP)

        btnRTP.setOnClickListener {

            val intent = Intent(this, Pause::class.java)
            startActivity(intent)
        }
        btnRTW.setOnClickListener {

            val intent = Intent(this, Workout::class.java)
            startActivity(intent)
        }
        btnRTHP.setOnClickListener {

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}