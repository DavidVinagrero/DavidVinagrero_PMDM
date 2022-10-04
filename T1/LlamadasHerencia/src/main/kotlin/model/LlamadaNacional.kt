package model

import Llamada

class LlamadaNacional(nOrigen: Int, nDestino: Int, duracion: Int, var franja: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    // Constructores
    init {
        when (franja) {
            1 -> { coste = duracion * 0.20 }
            2 -> { coste = duracion * 0.25 }
            3 -> { coste = duracion * 0.30 }
        }
    }

    // Funciones
    override fun mostrarDatos() {
        println("\nLlamada Nacional")
        super.mostrarDatos()
        println("Franja: $franja")
    }
}