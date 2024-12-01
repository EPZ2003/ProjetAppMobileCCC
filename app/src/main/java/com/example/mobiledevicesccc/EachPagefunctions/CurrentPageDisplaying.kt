package com.example.mobiledevicesccc.EachPagefunctions

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevicesccc.modelviepackage.CurrentPageListExercise
import com.example.mobiledevicesccc.modelviepackage.ViewModelGetAllData

@Composable
fun CurrentPageDisplaying(viewModel: ViewModelGetAllData){
    CurrentPageListExercise(viewModel)
}

