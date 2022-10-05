package model

abstract class Persona(var nombre: String, var apellido: String, var dni: String) {

    // Funciones
    open fun mostrarDatos() {
        println("\nNombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}