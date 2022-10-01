package model

open class Trabajador(nombre: String, apellido: String, dni: String, var NSS: Int)
    : Persona(nombre, apellido, dni) {

    //Funciones
    override fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
        println("NSS: $NSS")
    }
}