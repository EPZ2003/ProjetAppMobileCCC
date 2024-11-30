package com.example.mobiledevicesccc.EachPagefunctions

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobiledevicesccc.data.Exercise
import com.example.mobiledevicesccc.modelviepackage.RestTimeTimerExercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId

import com.example.mobiledevicesccc.pages.Workout
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

@Composable
fun RestTimeDisplaying(viewModel: ViewModelGetId,id: Int,context: Context){

    RestTimeTimerExercise(viewModel,id,context)
}