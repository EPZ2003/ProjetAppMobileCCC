package com.example.mobiledevicesccc.navButton

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobiledevicesccc.pages.RestTime
import com.example.mobiledevicesccc.pages.TrackingWorkout
import com.example.mobiledevicesccc.pages.Workout

//Go to page WP
@Composable
fun StartNewActictivty(
    context: Context,
    activityClass: Class<*>,
    text : String,
    modifier: Modifier = Modifier

) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd // Align the button to the bottom-right corner
    ) {
        Button(
            onClick = {
                val intent = Intent(context, activityClass)
                context.startActivity(intent)
            }
        ) {
            Text(text = text)
        }

    }
}

//Go to page WP
@Composable
fun GoToPause(
    context: Context,
    activityClass: Class<*>,

    modifier: Modifier = Modifier

)
{Box(
    modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
    contentAlignment = Alignment.Center // Align the button to the bottom-right corner
) {

    Button(
        onClick = {
            // Navigate to RestTime activity
            val intent = Intent(context, RestTime::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth() // Make the button take full width
            .height(48.dp) // Optional height for the button
    ) {
        Text(text = "Rest Time")
    }
}
}


@Composable
fun CancelRestTimePage(context: Context){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd // Align the button to the bottom-right corner
    ){

    Button(
        onClick = {
            // Navigate to RestTime activity
            TrackingWorkout.tracking--
            val intent = Intent(context, Workout::class.java)
            context.startActivity(intent)
        },
    ) { Text(text = "Cancel") }
    }
}

@Preview
@Composable
fun Test(){
    CancelRestTimePage(context = LocalContext.current)
}
