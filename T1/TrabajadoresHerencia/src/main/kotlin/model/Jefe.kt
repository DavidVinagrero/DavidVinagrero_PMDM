package model

class Jefe (nombre: String, apellido: String, dni:String, var acciones: Double, var beneficio: Double)
    : Persona(nombre, apellido, dni){

    // Métodos override
    override fun mostrarDatos() {
        println("Jefe")
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
    }
}