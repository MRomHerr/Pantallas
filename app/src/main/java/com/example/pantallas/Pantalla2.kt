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

class Pantalla2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallasTheme {
                Pantalla2Content()
            }
        }
    }
}

@Composable
fun Pantalla2Content() {
    // estado que controla la conversacion
    var dialogState by remember { mutableStateOf(0) }
    // imagen que cambiara segun el estado
    var imageResource by remember { mutableStateOf(R.drawable.kuenkro) }

    val context = LocalContext.current // obtenemos el contexto dentro de un composable
    // imagenes de las conversaciones
    val image1: Painter = painterResource(id = R.drawable.kuenkro) // imagen inicial
    val image2: Painter = painterResource(id = R.drawable.knekrofeliz) // imagen despues de la conversacion

    // definimos el texto de la conversacion basado en el estado
    val conversationText = when (dialogState) {
        0 -> "Kuenkro: Hola lokete"
        1 -> "2: Abuelo?!"
        2 -> "Kuenkro: ¿Unas cartitas al pokemon?"
        3 -> "2: Venga"
        4 -> "Kuenkro: jeje god"
        else -> "Fin de la conversacion"
    }

    // si la conversacion llega a "Venga", cambiamos la imagen
    if (dialogState == 4) {
        imageResource = R.drawable.knekrofeliz
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
            contentDescription = "Imagen Kuenkro",
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
                if (dialogState < 4) {
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

        // mostrar el segundo boton cuando el dialogo ha terminado (estado 4)
        if (dialogState == 4) {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navigateToMainActivity() } // navegar a la MainActivity
            ) {
                Text(
                    text = "Volver al inicio",
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}


