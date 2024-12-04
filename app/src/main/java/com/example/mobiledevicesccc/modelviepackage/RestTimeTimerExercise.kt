package com.example.mobiledevicesccc.modelviepackage

import android.content.Context
import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.pages.Workout
import kotlinx.coroutines.delay

@Composable
fun RestTimeTimerExercise(viewModel: ViewModelGetId,id: Int,context: Context) {
    val exercise by viewModel.getchEntityById(id).collectAsState(initial = null)
    if (exercise != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TitleRestTime()
            CircularTimer(exercise!!,context)
        }

    }else{
        Text("")
    }

}

@Composable
fun TitleRestTime(){
    Text(
        text = "Rest Time",
        fontSize = 46.sp, // Large font size for title
        fontWeight = FontWeight.Bold, // Bold font
        textAlign = TextAlign.Center // Center the text
    )
}

@Composable
fun CircularTimer(
    exercise : Exercise,
    context: Context,
    modifier: Modifier = Modifier,
    size: Float = 300f, // Diameter of the circle
    strokeWidth: Float = 10f, // Thickness of the progress stroke
    primaryColor: Color = Color.Yellow, // Progress bar color
    backgroundColor: Color = Color.LightGray, // Background circle color
    textColor: Color = Color.Black, // Timer text color
    textSize: TextUnit = 42.sp // Size of the timer text
) {
// Collect the Exercise object from the Flow


    val totalTime = exercise.time.toInt()
    var currentTime by remember { mutableIntStateOf(totalTime) }
    val progress by animateFloatAsState(targetValue = currentTime.toFloat() / totalTime, label = "")

    var isPaused by remember { mutableStateOf(false) }

    LaunchedEffect(currentTime,isPaused) {

        if (currentTime > 0 && isPaused == false) {
            delay(1000L)
            currentTime--

        }else if (currentTime == 0){
            delay(500L)
            val intent = Intent(context, Workout::class.java)
            context.startActivity(intent)

        }
    }



    Box(
        contentAlignment = Alignment.Center, // Center everything in the box
        modifier = Modifier
            .fillMaxSize() // Fill the entire screen
    ) {
        // Circular Progress Bar
        Canvas(modifier = Modifier.size(size.dp)) {
            val canvasSize = size * this.density
            val center = Offset(canvasSize / 2, canvasSize / 2)
            val radius = (canvasSize - strokeWidth) / 2

            // Draw background circle
            drawCircle(
                color = backgroundColor,
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth)
            )

            // Draw progress arc
            drawArc(
                color = primaryColor,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }
        Button(
            onClick = { isPaused = !isPaused }, // Toggle isPaused state
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF003366), contentColor = Color.White)
        ) {
            Text(
                fontSize = 42.sp,
                text = if (isPaused) "Resume" else "${currentTime} s"
            ) // Change button text dynamically
        }
    }


}
