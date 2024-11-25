package com.example.mobiledevicesccc

import android.content.Context
import androidx.compose.ui.platform.LocalContext

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity



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
        setContent {
            HomeScreen()
            startNewActictivty(context = this, activityClass = WorkoutPlanning::class.java)
            startNewActictivty(context = this, activityClass = Workout::class.java)
        }

    }

}



@Composable
fun HomeScreen (){
    Column {
        MessageCard()

    }
}



@Composable
fun MessageCard() {
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

        // Subtitle
        Text(
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
    MessageCard()

}