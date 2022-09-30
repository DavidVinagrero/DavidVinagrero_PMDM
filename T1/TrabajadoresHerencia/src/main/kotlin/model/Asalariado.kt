package model

class Asalariado(nombre: String, apellido: String, dni: String, var sueldo: Int, var numeroPagas: Int, var contratado: Boolean)
    : Persona(nombre, apellido, dni) {

    // Métodos override
    override fun mostrarDatos() {
        println("Asalariado")
        super.mostrarDatos()
        println("Sueldo: $sueldo")
        println("Número de pagas: $numeroPagas")
        println("Contratado: $contratado")
    }
}