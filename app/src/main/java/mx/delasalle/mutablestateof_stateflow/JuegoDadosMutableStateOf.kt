package mx.delasalle.mutablestateof_stateflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Preview(showBackground = true)
@Composable
fun JuegoDadosStateOfPreview() {
    JuegoDadosStateOf()
}

@Composable
fun JuegoDadosStateOf(){
    // Estado mutable que almacena el número del dado actual
    var diceNumber by remember { mutableStateOf(1) }
    // Función para generar un número aleatorio entre 1 y 6
    fun lanzarDado() {
        diceNumber = Random.nextInt(1, 7)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido al juego de suerte")
        Spacer(modifier = Modifier.height(20.dp))
        // Mostrar la imagen correspondiente al número del dado
        Image(
            painter = painterResource(id = getImagen(diceNumber)),
            contentDescription = "Dice Image",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para lanzar el dado
        Button(onClick = { lanzarDado() }) {
            Text(text = "Lanzar Dado")
        }
    }
}

// Función para obtener el recurso de imagen del dado según el número
fun getImagen(diceNumber: Int): Int {
    return when (diceNumber) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
}