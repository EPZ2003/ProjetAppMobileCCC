package com.example.mobiledevicesccc

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Workout : ComponentActivity() {
    /*@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workout)

        val btnRestTimeW = findViewById<Button>(R.id.btnRestTimeW)
        val btnWHP = findViewById<Button>(R.id.btnWHP)

        btnRestTimeW.setOnClickListener {

            val intent = Intent(this,RestTime::class.java)
            startActivity(intent)
        }
        btnWHP.setOnClickListener {

            val intent = Intent(this,WorkoutPlanning::class.java)
            startActivity(intent)
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            displayWorkout(context = this)


        }

    }
}

class TrackingWorkout {
    companion object {
        var begin = 1
        var tracking = 5 // TODO LINK WHEN YOU CLICK INTO THE REST TIME BUTTON
    }
}
@Composable
fun displayWorkout(context: Context){
    var status = ""
    val backgroundColors = listOf(
        Color.Gray,
        Color(0xFFFFA500), // Orange
        Color.Gray
    )
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title()
        if (TrackingWorkout.tracking > stringList.size){
            TrackingWorkout.tracking = TrackingWorkout.begin
        }
        for (i in 0 .. 2){
            when(i){
                0 -> status = "Passed"
                1 -> status = "1:32 m"//devoir prendre le time en compte
                2 -> status = "Coming after"
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(16.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth() // Make the row fill the available width
                        .background(backgroundColors[i])
                ) {
                    Text(
                        text = stringList[i+TrackingWorkout.tracking],
                        fontSize = 46.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Text(
                        text = status,
                        modifier = Modifier
                            // Align this element to the right
                            .background(color = Color.Cyan )
                    )

                }
                Row {
                    Text(
                        text = "",
                        modifier = Modifier
                            // Align this element to the right

                            .padding(34.dp)

                    )

                }
            }

        }
        DisplayBtn(context)
        StartNewActictivty(context, activityClass = RestTime::class.java)

    }

}

@Composable
fun Title (){

        Text(
            text = "Workout",
            fontSize = 56.sp, // Larger font for a title
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

}

@Composable
fun WorkoutPage (context: Context){

    displayWorkout(context)
}
@Composable
fun DisplayBtn(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Make the Column take full width
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.Bottom, // Space between buttons
        horizontalAlignment = Alignment.CenterHorizontally,
        // Center-align content
    ) {
        GoToPause(context = context, activityClass = RestTime::class.java)


    }

}

@Preview
@Composable
fun PreviewdisplayWorkout(){

    WorkoutPage(context = LocalContext.current)

}

