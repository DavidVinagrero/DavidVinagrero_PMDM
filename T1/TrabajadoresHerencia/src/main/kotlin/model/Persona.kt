package model

open class Persona(var nombre: String, var apellido: String, var dni: String) {
    // Constructores
    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}