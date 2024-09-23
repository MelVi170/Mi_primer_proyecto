package com.example.miapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miapp.ui.theme.MiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiAppTheme {
                Scaffold { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedLanguage by remember { mutableStateOf("Español") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = getWelcomeMessage(selectedLanguage),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = androidx.compose.ui.graphics.Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Aquí puedes comenzar a explorar nuestra app.",
            fontSize = 16.sp,
            color = androidx.compose.ui.graphics.Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botones para cambiar de idioma
        LanguageButton(language = "Español") { selectedLanguage = "Español" }
        LanguageButton(language = "Inglés") { selectedLanguage = "Inglés" }
        LanguageButton(language = "Francés") { selectedLanguage = "Francés" }
        LanguageButton(language = "Alemán") { selectedLanguage = "Alemán" }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Acción del botón */ }) {
            Text(text = "Comenzar")
        }
    }
}

@Composable
fun LanguageButton(language: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = language)
    }
}

fun getWelcomeMessage(language: String): String {
    return when (language) {
        "Inglés" -> "Welcome to the app!"
        "Francés" -> "Bienvenue dans l'application!"
        "Alemán" -> "Willkommen in der App!"
        else -> "¡Bienvenido a la aplicación!"
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MiAppTheme {
        MainScreen()
    }
}
