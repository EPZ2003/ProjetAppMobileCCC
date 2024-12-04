package com.example.mobiledevicesccc.EachPagefunctions

import android.content.Context

import androidx.compose.runtime.Composable

import com.example.mobiledevicesccc.modelviepackage.RestTimeTimerExercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetId


@Composable
fun RestTimeDisplaying(viewModel: ViewModelGetId,id: Int,context: Context){

    RestTimeTimerExercise(viewModel,id,context)
}