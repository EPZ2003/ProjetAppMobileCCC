package com.example.mobiledevicesccc.DBFunctions

import android.content.Context
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData
import com.example.mobiledevicesccc.pages.DisplayPopUp

@Composable
fun AllWorkoutDisplaying(context: Context,viewModel: ViewModelGetAllData){
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
        DisplayPopUp(context,viewModel)
    }


}