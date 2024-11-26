package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkoutProgram : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        if (savedInstanceState != null) {
//            super.onSaveInstanceState(savedInstanceState)
//            super.onRestoreInstanceState(savedInstanceState)
//        }

        setContentView(R.layout.activity_workout_program)



        // Données à afficher
        val exercises = mutableListOf(
            Exercise(1, "Push-ups", 3, 30),
            Exercise(2, "Squats", 4, 20),
            Exercise(3, "Burpees", 5, 15),
            Exercise(4, "traction", 5, 15)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        val adapter = ExerciseAdapter(exercises) { selectedExercise ->

            // Gestion du clic sur le bouton Update
            val intent = Intent(this, UpdateExercice::class.java)
            intent.putExtra("EXERCISE_ID", selectedExercise.id)
            intent.putExtra("EXERCISE_NAME", selectedExercise.name)
            intent.putExtra("EXERCISE_ROUNDS", selectedExercise.round)
            intent.putExtra("EXERCISE_REST_TIME", selectedExercise.restTime)
            startActivity(intent)
        }


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Configuration glisser/deposer
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                adapter.swapItems(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        //Change the value of txtchooseWP by the passing button
        val txtChooseWP = findViewById<TextView>(R.id.txtchooseWP)
        val receiverTxt = intent.getStringExtra("KeyBtn")
        txtChooseWP.text = receiverTxt

        //Button
        val btnADD = findViewById<Button>(R.id.btnADD)
        val btnWPHP = findViewById<Button>(R.id.btnWPHP)
        val btnWPWP = findViewById<Button>(R.id.btnWPWP)

        btnADD.setOnClickListener {

            val intent = Intent(this,AddExercise::class.java)
            intent.putExtra("KeyBtnToADD",receiverTxt)
            startActivity(intent)

        }
        btnWPHP.setOnClickListener {
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }
        btnWPWP.setOnClickListener {
            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }

    }
// garde en memoire
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        // Sauvegarder la position de défilement actuelle
//        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//        val scrollPosition = layoutManager.findFirstVisibleItemPosition()
//        outState.putInt("scroll_position", scrollPosition)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        // Restaurer la position de défilement
//        val savedScrollPosition = savedInstanceState.getInt("scroll_position", 0)
//        recyclerView.scrollToPosition(savedScrollPosition)
//    }

}