package com.example.mobiledevicesccc.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Exercise::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase  : RoomDatabase() {
    abstract fun ExerciseDao(): ExerciseDao

    companion object {

        @Volatile
        private var Instance: ExerciseDatabase? = null

        fun getDatabase(context: Context) : ExerciseDatabase {
            return Instance?: synchronized(this) {
                Room.databaseBuilder(context, ExerciseDatabase::class.java, "Exercise_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}