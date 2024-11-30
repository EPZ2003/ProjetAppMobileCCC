package com.example.mobiledevicesccc.pages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevicesccc.R

class UpdateExercice : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_exercice)

        // Récupérer les données de l'Intent
        val exerciseId = intent.getIntExtra("EXERCISE_ID", -1)
        val exerciseName = intent.getStringExtra("EXERCISE_NAME")
        val exerciseRounds = intent.getIntExtra("EXERCISE_ROUNDS", 0)
        var exerciseRestTime = intent.getIntExtra("EXERCISE_REST_TIME", 0) //en miliseconde
        var exercisemin = exerciseRestTime / 60000
        var exercisesec = exerciseRestTime % 60000

        //Nouvelle varaiable
        val spinner = findViewById<Spinner>(R.id.attributeSpinner)
        val btnUEToWP = findViewById<Button>(R.id.btnUEToWP)
        val btnSubround = findViewById<Button>(R.id.submitRoundButton)
        val btnSubTime = findViewById<Button>(R.id.submitTimeButton)
        var roundtext = findViewById<EditText>(R.id.roundInput) // //zone de texte pour les round
        var mininput = findViewById<EditText>(R.id.MinInput) //zone de texte pour les minutes
        var sinput = findViewById<EditText>(R.id.SInput) //zone de texte pour les secondes
        var lblmin_s = findViewById<TextView>(R.id.lblmin_s)// affichage de min et s

        //Affichage de l'exercice selectionné
        var exercicetext = findViewById<TextView>(R.id.exercise)
        exercicetext.text = "Ex "+exerciseId+": "+exerciseName+"("+exerciseRounds+","+exercisemin+"m"+exercisesec+"s)"

        btnUEToWP.setOnClickListener {
            val intent = Intent(this, WorkoutProgram::class.java)
            startActivity(intent)
        }

        btnSubround.setOnClickListener{
            findViewById<EditText>(R.id.roundText).setText(roundtext.toString())
            exercicetext.text = "Ex "+exerciseId+": "+exerciseName+"("+roundtext.toString()+","+exercisemin+"m"+exercisesec+"s)"
        }

        btnUEToWP.setOnClickListener{
            findViewById<EditText>(R.id.restTimeText).setText(((sinput.toString()).toInt()+(mininput.toString()).toInt()).toString())

        }


        // Liste des attributs pour le Spinner
        val attributes = listOf("Select Attribute", "Round", "Rest Time")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, attributes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when (attributes[position]) {
                    "Round" -> {
                        roundtext.visibility = View.VISIBLE
                        btnSubround.visibility = View.VISIBLE
                        btnSubTime.visibility = View.INVISIBLE
                        mininput.visibility = View.INVISIBLE
                        sinput.visibility = View.INVISIBLE
                        lblmin_s.visibility = View.INVISIBLE
                        if(!roundtext.text.isNullOrEmpty())
                        {
                        }

                    }
                    "Rest Time" -> {
                        btnSubTime.visibility = View.VISIBLE
                        mininput.visibility = View.VISIBLE
                        sinput.visibility = View.VISIBLE
                        lblmin_s.visibility = View.VISIBLE
                        roundtext.visibility = View.INVISIBLE
                        btnSubround.visibility = View.INVISIBLE
                        if(!mininput.text.isNullOrEmpty() && !sinput.text.isNullOrEmpty())
                        {
                        }
                    }
                    else ->
                        {
                            btnSubTime.visibility = View.INVISIBLE
                            mininput.visibility = View.INVISIBLE
                            sinput.visibility = View.INVISIBLE
                            lblmin_s.visibility = View.INVISIBLE
                            roundtext.visibility = View.INVISIBLE
                            btnSubround.visibility = View.INVISIBLE
                        }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Rien à faire ici
            }
        }
    }
}
//TODO DOIT FINIR LES DEUX PAGES
