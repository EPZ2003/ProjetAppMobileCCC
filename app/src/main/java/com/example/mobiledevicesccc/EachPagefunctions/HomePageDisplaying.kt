package com.example.mobiledevicesccc.EachPagefunctions

import androidx.compose.runtime.Composable
import com.example.mobiledevicesccc.modelviepackage.HomepageListExercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData

@Composable
fun HomePageDisplaying(viewModel: ViewModelGetAllData){
    HomepageListExercise(viewModel)
}