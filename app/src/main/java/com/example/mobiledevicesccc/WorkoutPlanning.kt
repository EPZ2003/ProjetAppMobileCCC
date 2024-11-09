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

class WorkoutPlanning : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_workout_planning)

        val btnGoToHP = findViewById<Button>(R.id.goToHomePage)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        btnGoToHP.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }
        btn1.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","1")
            startActivity(intent)

        }
        btn2.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)

            val txtChoose = findViewById<TextView>(R.id.txtchooseWP)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","2")
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","3")
            startActivity(intent)


        }
        btn4.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","4")
            startActivity(intent)


        }
        btn5.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","5")
            startActivity(intent)


        }
        btn6.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            intent.putExtra("KeyBtn","6")
            startActivity(intent)


        }



    }
}