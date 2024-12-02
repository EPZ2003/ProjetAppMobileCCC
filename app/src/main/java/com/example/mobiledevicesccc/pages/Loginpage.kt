package com.example.mobiledevicesccc.pages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevicesccc.navButton.StartNewActictivty


class LoginPage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TitleLogin()
                LoginCompose(context = LocalContext.current)
            }
        }
    }
}

@Composable
fun LoginCompose(context : Context){
    var text by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var statusPWD by remember { mutableStateOf(false) }
    var statusLog by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = text,
            onValueChange = { newText ->
                if (newText =="admin") {
                    statusLog = true
                } else {
                    errorMessage = null
                }
                text = newText
            },
            label = { Text("Enter your input") },
            isError = errorMessage != null, // Highlight in red if there's an error
            modifier = Modifier.fillMaxWidth().padding(16.dp),

        )

        TextField(
            value = pwd,
            onValueChange = { newText ->
                if (newText =="root1234") {
                    statusPWD = true
                } else {
                    errorMessage = null
                }
                pwd = newText
            },
            label = { Text("Enter your input") },
            isError = errorMessage != null, // Highlight in red if there's an error
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            visualTransformation = PasswordVisualTransformation(),
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }


    }
    Button(
        onClick = {
            if (statusLog && statusPWD) {
                val intent = Intent(context, HomePage::class.java)
                context.startActivity(intent)
            }else{
                errorMessage = "Wrong login or password"
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text(text = "Login")
    }
}

@Composable
fun TitleLogin(){
    Text(
        text = "Login",
        fontSize = 56.sp, // Larger font for a title
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth())

}
