package com.example.mobiledevicesccc.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Exercise")
data class Exercise (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val round: Int,
    val time: String,
    val typeExercise: String

)