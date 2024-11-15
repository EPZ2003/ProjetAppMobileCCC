package com.example.mobiledevicesccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapp.GreetingMessage
import androidx.compose.ui.platform.ComposeView



class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_homepage)

        val btnGoToWP = findViewById<Button>(R.id.GoToWP)


        btnGoToWP.setOnClickListener {

            val intent = Intent(this, WorkoutPlanning::class.java)
            startActivity(intent)

        }

        val composeView = findViewById<ComposeView>(R.id.composeView)
        composeView.setContent {
            HomePageComposable()
    }}

    @Composable
    fun MyButton() {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Clicked $count times")
        }
    }

    @SuppressLint("NotConstructor")
    @Composable
    fun HomePage() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            GreetingMessage(name = "World")
            MyButton()
        }
    }
@Composable
fun HomePageComposable() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                GreetingMessage(name = "World")
                MyButton()
                }
            }
}