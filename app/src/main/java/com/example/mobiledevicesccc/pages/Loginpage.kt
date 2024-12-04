package com.example.mobiledevicesccc.pages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Ajout d'un peu de marge pour ne pas coller aux bords
                contentAlignment = Alignment.Center // Centre les éléments verticalement et horizontalement
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement les éléments de la colonne
                ) {
                    TitleLogin()
                    Spacer(modifier = Modifier.height(24.dp)) // Espace entre le titre et le formulaire
                    LoginCompose(context = LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun TitleLogin() {
    Text(
        text = "Login",
        fontSize = 34.sp, // Taille de police pour un titre
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LoginCompose(context: Context) {
    var text by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var statusPWD by remember { mutableStateOf(false) }
    var statusLog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centre les champs horizontalement
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                if (newText == "admin") {
                    statusLog = true
                } else {
                    errorMessage = null
                }
                text = newText
            },
            label = { Text("Username") },
            isError = errorMessage != null, // Met en surbrillance en rouge s'il y a une erreur
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp)) // Ajoute un espace entre les champs

        TextField(
            value = pwd,
            onValueChange = { newText ->
                if (newText == "root1234") {
                    statusPWD = true
                } else {
                    errorMessage = null
                }
                pwd = newText
            },
            label = { Text("Password") },
            isError = errorMessage != null,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espace entre le champ et le message d'erreur

        if (errorMessage != null) {
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espace entre le message d'erreur et le bouton

        Button(
            onClick = {
                if (statusLog && statusPWD) {
                    val intent = Intent(context, HomePage::class.java)
                    context.startActivity(intent)
                } else {
                    errorMessage = "Wrong login or password"
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF003366), // Couleur de fond du bouton
                contentColor = Color.White  // Couleur du texte
            )
        ) {
            Text(text = "Login")
        }
    }
}

