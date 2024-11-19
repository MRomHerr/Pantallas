package com.example.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallas.ui.theme.PantallasTheme

class Pantalla1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallasTheme {
                Pantalla1Content()
            }
        }
    }
}

@Composable
fun Pantalla1Content() {
    val context = LocalContext.current // Obtén el contexto dentro de un composable

    val image: Painter = painterResource(id = R.drawable.kuenkro) // Asegúrate de que tu imagen esté en drawable

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra la imagen
        Image(
            painter = image,
            contentDescription = "Imagen Kuenkro",
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Muestra el texto
        Text(
            text = "Hola lokete",
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontSize = 24.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Botón para regresar a la pantalla anterior
        Button(onClick = {
            // Verifica y cierra la actividad actual usando el contexto
            (context as? ComponentActivity)?.finish()
        }) {
            Text(
                text = "Abuelo?!",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantalla1() {
    PantallasTheme {
        Pantalla1Content()
    }
}
