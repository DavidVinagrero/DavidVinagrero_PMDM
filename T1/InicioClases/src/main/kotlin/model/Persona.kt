package model

open class Persona (var nombre:String, var apellido: String, var edad: Int){

    //Variables nombre, apellido
    //Todas las variables en constructor primario tienen constructor implícito
    lateinit var dni: String
    var peso:Double?= null;

    constructor(nombre: String, apellido: String, edad: Int, peso: Double): this(nombre,apellido,edad){
        this.peso= peso
    }

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Edad: $edad")
    }

    fun setDNI(dni:String){
        this.dni= dni;
    }

    fun getDNI(): String{
        return this.dni;
    }
}