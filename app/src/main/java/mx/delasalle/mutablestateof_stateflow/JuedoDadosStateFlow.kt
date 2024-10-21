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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun JuegoDadosStateFlow( viewModel: JuegoDadosViewModel = viewModel()){
    // Recogemos el estado del dado desde el ViewModel con collectAsState
    val diceNumber by viewModel.diceNumber.collectAsState()

    // UI
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la imagen correspondiente al número del dado
        Image(
            painter = painterResource(id = getImagenDado(diceNumber)),
            contentDescription = "Dice Image",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para lanzar el dado
        Button(onClick = { viewModel.tirarDado() }) {
            Text(text = "Roll Dice")
        }
    }
}

// Función para obtener el recurso de imagen del dado según el número
fun getImagenDado(diceNumber: Int): Int {
    return when (diceNumber) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
}
