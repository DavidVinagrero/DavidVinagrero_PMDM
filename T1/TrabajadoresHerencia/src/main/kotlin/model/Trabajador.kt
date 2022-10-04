package model

open abstract class Trabajador(var nombre: String, var apellido: String, var dni: String) {

    fun mostrarTrabajador(){
        println("Nombre: "+nombre)
        println("Apellido: "+apellido)
        println("DNI: "+dni)
    }

}