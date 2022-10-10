package model

abstract class Comun(var id:Int, var nombre: String) {

    // Funciones
    open fun mostrarDatos(){
        println("\n$nombre  $id")
    }
}