package com.example.mobiledevicesccc


import android.content.Context
import android.content.Intent
import androidx.compose.ui.platform.LocalContext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room

import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.navButton.StartNewActictivty
import kotlinx.coroutines.flow.Flow


//AppCompatActivity()
class HomePage : ComponentActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val btnGoToWP = findViewById<Button>(R.id.GoToWP)
        

        btnGoToWP.setOnClickListener {

            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }




    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            ExerciseDatabase::class.java, "Exercise_database"
        ).build()
        val exerciseDao = db.ExerciseDao()
        val exercise: Flow<List<Exercise>> = exerciseDao.getAllExercise()

        setContent {

            MessageCard(context = this)
            StartNewActictivty(context = this, activityClass = WorkoutPlanning::class.java)


        }

    }

}



@Composable
fun DisplayPopUp (
    context: Context,

){

    val stringList = listOf(
        "Workout Planning",
        "Yoga Session",
        "Cardio Exercise",
        "Strength Training",
        "Flexibility Training",
        "Meditation",
        "Pilates",
        "CrossFit",
        "Cycling",
        "Swimming"
    )
    Column() {
        for (i in 1..stringList.size - 1) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = stringList[i])
                Text(text = "-->")
                Text(text = "5 rounds")
                Text(text = "1m 40s")
            }

        }

        Button(onClick = {
            context.startActivity(Intent(context,Workout::class.java))
        }) {
            Text(text = "GO !")
        }
    }
}




@Composable
fun AllWorkoutDisplaying(context: Context){
    var showDialog  by remember { mutableStateOf(false) }

    Column(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }

            }) {
                Text("Workout 1")

            }
            //pacebetween Item
            Box(
                modifier = Modifier
                    .width(30.dp) // Spacer width
                    .height(20.dp) // Same height as your row items
                //.background(Color.Red) // Visualize the space
            )
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }
            }) {
                Text(text = "Workout 2")
            }
            //Spacebetween Item
            Box(
                modifier = Modifier
                    .width(30.dp) // Spacer width
                    .height(20.dp) // Same height as your row items
                //.background(Color.Red) // Visualize the space
            )
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }
            }) {
                Text(text = "Workout 3")
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }
            }) {
                Text(text = "Workout 4")
            }
            //Spacebetween Item
            Box(
                modifier = Modifier
                    .width(30.dp) // Spacer width
                    .height(20.dp) // Same height as your row items
                //.background(Color.Red) // Visualize the space
            )
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }
            }) {
                Text(text = "Workout 5")
            }
            //Spacebetween Item
            Box(
                modifier = Modifier
                    .width(30.dp) // Spacer width
                    .height(20.dp) // Same height as your row items
                //.background(Color.Red) // Visualize the space usefull for debug UI
            )
            Button(onClick = {
                when(showDialog){
                    true -> showDialog = false
                    false -> showDialog = true
                }
            }) {
                Text(text = "Workout 6")
            }

        }

    }
        //Display or not the list With the workout associated
        if(showDialog){
            DisplayPopUp(context)
        }


}




@Composable
fun MessageCard(context : Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center the content horizontally
    ) {
        // Title
        Text(
            text = "HomePage",
            fontSize = 46.sp, // Large font size for title
            fontWeight = FontWeight.Bold, // Bold font
            textAlign = TextAlign.Center, // Center the text
            modifier = Modifier.padding(bottom = 8.dp) // Spacing below the title
        )
        AllWorkoutDisplaying(context)
        // Subtitle
        Text(
            modifier = Modifier.padding(top = 50.dp), // Spacing below the title
            text = "Choose your workout of the day",
            fontSize = 24.sp, // Smaller font size for subtitle
            fontWeight = FontWeight.Normal, // Normal weight for subtitle
            textAlign = TextAlign.Center // Center the text
        )
    }
}


@Preview
@Composable
fun PreviewMessageCard() {
    val context = LocalContext.current

    //MessageCard(context)

}