package com.example.mobiledevicesccc.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
/*
*The following code defines a DAO called UserDao. UserDao provides the methods that
* the rest of the app uses to interact with data in the user table.
* */
@Dao
interface SportExerciseDAO {

    @Query("SELECT * FROM SportExercise")
    fun getAll(): List<SportExercise>

    @Query("SELECT * FROM SportExercise WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds : IntArray) : List<SportExercise>

    @Insert
    fun insertAll(sportExo: SportExercise)

    @Delete
    fun delete(sportExo: SportExercise)
}
