package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevicesccc.R

class WorkoutProgram : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_workout_program)



        //Change the value of txtchooseWP by the passing button
        val txtChooseWP = findViewById<TextView>(R.id.txtchooseWP)
        val receiverTxt = intent.getStringExtra("KeyBtn")
        txtChooseWP.text = receiverTxt

        //Button
        val btnADD = findViewById<Button>(R.id.btnADD)
        val btnWPHP = findViewById<Button>(R.id.btnWPHP)
        val btnWPWP = findViewById<Button>(R.id.btnWPWP)

        btnADD.setOnClickListener {

            val intent = Intent(this, AddExercise::class.java)
            intent.putExtra("KeyBtnToADD",receiverTxt)
            startActivity(intent)

        }
        btnWPHP.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        btnWPWP.setOnClickListener {
            val intent = Intent(this, WorkoutPlanning::class.java)
            startActivity(intent)
        }


    }
}