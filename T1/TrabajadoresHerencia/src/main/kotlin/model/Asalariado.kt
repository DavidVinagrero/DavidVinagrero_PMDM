package model

class Asalariado(nombre: String, apellido: String, dni: String, nss:Int, var sueldo: Int, var numeroPagas: Int, var contratado: Boolean)
    : Trabajador(nombre, apellido, dni, nss) {

    // Métodos override
    override fun mostrarDatos() {
        println("Asalariado")
        super.mostrarDatos()
        println("Sueldo: $sueldo")
        println("Número de pagas: $numeroPagas")
        println("Contratado: $contratado")
    }
}