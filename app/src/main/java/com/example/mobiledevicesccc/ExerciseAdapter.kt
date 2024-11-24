package com.example.mobiledevicesccc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

class ExerciseAdapter(private val exercises: MutableList<Exercise>, private val onUpdateClicked: (Exercise) -> Unit) : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>()
{
    class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val nameText: TextView = view.findViewById(R.id.exerciseName)
        val roundText: TextView = view.findViewById(R.id.roundText)
        val restTimeText: TextView = view.findViewById(R.id.restTimeText)
        val updateButton: Button = view.findViewById(R.id.updateButton)
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_form, parent, false)
            return ExerciseViewHolder(view)
        }

        override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int)
        {
            val exercise = exercises[position]
            holder.nameText.text = exercise.name
            holder.roundText.text = "Round: ${exercise.round}"
            holder.restTimeText.text = "Rest Time: ${exercise.restTime}s"

            holder.updateButton.setOnClickListener { onUpdateClicked(exercise) }
        }

        override fun getItemCount(): Int = exercises.size

        // Fonction pour échanger deux éléments
        fun swapItems(fromPosition: Int, toPosition: Int) {
            Collections.swap(exercises, fromPosition, toPosition)
            notifyItemMoved(fromPosition, toPosition)
        }
}