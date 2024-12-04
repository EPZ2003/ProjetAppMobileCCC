package com.example.mobiledevicesccc.pages


import android.content.Context
import android.content.Intent
import androidx.compose.ui.platform.LocalContext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.mobiledevicesccc.DBFunctions.AllWorkoutDisplaying
import com.example.mobiledevicesccc.EachPagefunctions.HomePageDisplaying

import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.data.ExerciseDatabase
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import com.example.mobiledevicesccc.navButton.StartNewActictivty
import kotlinx.coroutines.flow.Flow


//AppCompatActivity()
class HomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1er etape initie DB
        val db = Room.databaseBuilder(
            applicationContext,
            ExerciseDatabase::class.java, "Exercise_database"
        ).build()
        //2eme etape creer DAO
        val exerciseDao = db.ExerciseDao()

        //3eme etape creer viewmodel

        //val exercise: Flow<List<Exercise>> = exerciseDao.getAllExercise()
        val viewModel = ViewModelGetAllData(exerciseDao)
        setContent {

            //HomePageDisplaying(viewModel)
            MessageCard(context = this,viewModel)
            StartNewActictivty(context = this, activityClass = WorkoutPlanning::class.java, text = "Workout Planning")
            GotoLogin(context = this)

        }

    }

}



@Composable
fun DisplayPopUp(
    context: Context,
    viewModel: ViewModelGetAllData
) {
    Column {
        HomePageDisplaying(viewModel)

        Button(
            onClick = {
                context.startActivity(Intent(context, Workout::class.java))
            },
            colors = ButtonDefaults.buttonColors(Color.Black,Color.White)
        ) {
            Text(text = "GO !")
        }
    }
}


@Composable
fun GotoLogin (
    context : Context
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart// Align the button to the bottom-right corner
    ) {
        Button(
            onClick = {
                val intent = Intent(context, LoginPage::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF003366), contentColor = Color.White)
        ) {
            Text(text = "Return to Login Page")
        }
    }
}







@Composable
fun MessageCard(context : Context,viewModel: ViewModelGetAllData) {
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
        AllWorkoutDisplaying(context,viewModel)
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