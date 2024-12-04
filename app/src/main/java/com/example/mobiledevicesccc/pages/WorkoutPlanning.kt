package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.mobiledevicesccc.R
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import kotlinx.coroutines.flow.Flow

class WorkoutPlanning : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, ExerciseDatabase::class.java, "Exercise_database").build()
        val exerciseDao = db.ExerciseDao()
        val viewModel = ViewModelGetAllData(exerciseDao)

        setContentView(R.layout.activity_workout_planning)

        val btnGoToHP = findViewById<Button>(R.id.goToHomePage)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        btnGoToHP.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        btn1.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)

            //Change the value of the Saving to the page WorkoutProgram

            viewModel.updateValue("1")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)

        }
        btn2.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)

            val txtChoose = findViewById<TextView>(R.id.txtchooseWP)
            //Change the value of the Saving to the page WorkoutProgram
            viewModel.updateValue("2")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            viewModel.updateValue("3")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)


        }
        btn4.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            viewModel.updateValue("4")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)


        }
        btn5.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            viewModel.updateValue("5")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)


        }
        btn6.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            //Change the value of the Saving to the page WorkoutProgram
            viewModel.updateValue("6")
            intent.putExtra("KeyBtn",viewModel.sharedValue)
            startActivity(intent)


        }



    }
}