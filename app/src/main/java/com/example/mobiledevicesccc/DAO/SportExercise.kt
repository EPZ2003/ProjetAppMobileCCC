package com.example.mobiledevicesccc.DAO

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

/*
* The following code defines a User data entity. Each instance
* of User represents a row in a user table in the app's database.
* */
data class SportExercise (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "sport_type") val sportTypes: String?,
    @ColumnInfo(name = "time") val time: String?
)