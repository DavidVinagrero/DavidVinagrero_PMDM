package model

import Llamada

class LlamadaProvincial(nOrigen: Int, nDestino: Int, duracion: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    // Constructores
    init {
        coste = duracion * 0.15
    }

    // Funciones
    override fun mostrarDatos() {
        println("\nLlamada Provincial")
        super.mostrarDatos()
    }
}