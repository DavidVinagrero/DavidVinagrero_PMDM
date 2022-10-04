package model

import Llamada

class LlamadaLocal(nOrigen: Int, nDestino: Int, duracion: Int, var localidad: String) : Llamada(nOrigen, nDestino, duracion) {

    // Funciones
    override fun mostrarDatos() {
        println("\nLlamada Local")
        super.mostrarDatos()
        println("Localidad: $localidad")
    }

    //
}