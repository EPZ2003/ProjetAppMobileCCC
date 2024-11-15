package com.example.composeapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun GreetingMessage(name: String) {
    Text(text = "Hello, $name!")
}

