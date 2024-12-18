package com.example.pantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
    // estado que controla la conversacion
    var dialogState by remember { mutableStateOf(0) }
    // imagen que cambiara segun el estado
    var imageResource by remember { mutableStateOf(R.drawable.zoolander) }

    val context = LocalContext.current // obtenemos el contexto dentro de un composable
    // imagenes de las conversaciones
    val image1: Painter = painterResource(id = R.drawable.zoolander) // imagen inicial
    val image2: Painter = painterResource(id = R.drawable.zoolander2) // imagen despues de la conversacion

    // definimos el texto de la conversacion basado en el estado
    val conversationText = when (dialogState) {
        0 -> "Estas caminando tranquilamente con lo primero que viste en el armario"
        1 -> "Pero de pronto se te acerca un indigente"
        else -> "Fin de la conversacion"
    }

    // si la conversacion llega a "Venga", cambiamos la imagen
    if (dialogState == 1) {
        imageResource = R.drawable.zoolander2
    }

    // funcion para regresar a la pantalla inicial
    fun navigateToMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // mostrar la imagen
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Imagen zoolander",
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // mostrar el dialogo
        Text(
            text = conversationText,
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontSize = 24.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // boton para avanzar en la conversacion
        Button(
            onClick = {
                if (dialogState < 1) {
                    dialogState++ // aumentamos el estado para avanzar en la conversacion
                }
            }
        ) {
            Text(
                text = "Siguiente",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            )
        }

        // Cuando la conversación termina (diálogo en estado 2 o más)
        if (dialogState == 1) {
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val intent = Intent(context, Pantalla2::class.java)
                context.startActivity(intent)
            }) {
                Text(text = "continuar",
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,  // Default=Roboto  SansSerif=Noto   Serif=Merriweather  Monospace=Fuentes monoespaciadas
                        fontSize = 24.sp,
                        color = Color.Black)
                )
            }
        }
    }
}