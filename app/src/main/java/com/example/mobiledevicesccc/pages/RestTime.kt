package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.room.Room
import com.example.mobiledevicesccc.EachPagefunctions.RestTimeDisplaying


import com.example.mobiledevicesccc.data.ExerciseDatabase

import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId
import com.example.mobiledevicesccc.navButton.CancelRestTimePage





class RestTime : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            ExerciseDatabase::class.java, "Exercise_database"
        ).build()
        val exerciseDao = db.ExerciseDao()

        val viewModel = ViewModelGetId(exerciseDao)
        setContent {
            RestTimeDisplaying(viewModel, TrackingWorkout.tracking,context = this)
            CancelRestTimePage(context = this)
        }
    }
}

