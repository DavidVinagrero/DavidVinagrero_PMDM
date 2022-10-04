open abstract class Llamada(var nOrigen: Int, var nDestino: Int, var duracion: Int) {

    // Variables
    var coste: Double = 0.0

    // Funciones
    open fun mostrarDatos() {
        println("Nº de Orígen: $nOrigen")
        println("Nº de Destino: $nDestino")
        println("Duración: $duracion")
        println("Coste = $coste")
    }
}