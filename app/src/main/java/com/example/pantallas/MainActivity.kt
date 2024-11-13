package com.example.pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.pantallas.ui.theme.PantallasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallasTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Obtén el contexto aquí
    val context = LocalContext.current

    // La interfaz de usuario principal con un botón
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Se te acercó un indigente",
            style = TextStyle(
                fontFamily = FontFamily.Monospace,  // Default=Roboto  SansSerif=Noto   Serif=Merriweather  Monospace=Fuentes monoespaciadas
                fontSize = 24.sp,
                color = Color.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Botón que navega a la otra pantalla
        Button(onClick = {
            val intent = Intent(context, Pantalla1::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Siguiente pantalla",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,  // Default=Roboto  SansSerif=Noto   Serif=Merriweather  Monospace=Fuentes monoespaciadas
                    fontSize = 24.sp,
                    color = Color.Black)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PantallasTheme {
        MainScreen()
    }
}
