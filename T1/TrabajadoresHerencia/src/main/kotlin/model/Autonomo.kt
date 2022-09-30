package model

class Autonomo(nombre: String, apellido: String, dni: String, var sueldo: Int, var contratado: Boolean)
    : Persona(nombre, apellido, dni) {

    //Métodos override
    override fun mostrarDatos() {
        println("Autónomo")
        super.mostrarDatos()
        println("Sueldo: $sueldo")
        println("Contratado: $contratado")
    }
}