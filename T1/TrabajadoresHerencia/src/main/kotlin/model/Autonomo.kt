package model

class Autonomo(nombre: String, apellido: String, dni: String, NSS:Int, var sueldo: Int, var contratado: Boolean)
    : Trabajador(nombre, apellido, dni, NSS) {

    //Métodos override
    override fun mostrarDatos() {
        println("Autónomo")
        super.mostrarDatos()
        println("Sueldo: $sueldo")
        println("Contratado: $contratado")
    }
}