package model

class Jefe(nombre: String, apellido: String, dni: String, NSS: Int, var acciones: Double, var beneficio: Double) :
    Trabajador(nombre, apellido, dni, NSS) {

    // Métodos override
    override fun mostrarDatos() {
        println("Jefe")
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
    }
}