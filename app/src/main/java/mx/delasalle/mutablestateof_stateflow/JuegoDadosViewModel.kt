package mx.delasalle.mutablestateof_stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.ViewModelInitializer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class JuegoDadosViewModel: ViewModel() {
    // Estado del número del dado, gestionado por un StateFlow
    private val _diceNumber = MutableStateFlow(1)
    val diceNumber: StateFlow<Int> = _diceNumber.asStateFlow()

    // Función para lanzar el dado y actualizar el número de forma reactiva
    fun tirarDado() {
        _diceNumber.value = Random.nextInt(1, 7)
    }
}