package model

// final
// open
class Coche(var marca: String, var modelo: String) {
    //Atributos
    var bastidor: String?= null
    var cc: Int= 0
    var cv: Int= 0
    get()= field
    set(cc) {
        field=cv
    }

    lateinit var propietario: Propietario

    //Constructores
    constructor(marca: String, modelo: String, bastidor: String):this(marca,modelo){
        this.bastidor= bastidor
    }

    //Bloque ejecutado tras cualquier constructor
    init {
        propietario= Propietario("Alfonso","García","12345678A")
    }

    //Funciones
    var mostrarDatos:()->Unit= {
        println("Marca: $marca")
        println("Modelo: $modelo")
        println("CV: $cv")
        println("CC: $cc")
    }

    fun calcularParMotor(calculoPar:(Int)->Int, aceleracion: Int){
        calculoPar(aceleracion);
    }

    fun asignarPropietario(propietario: Propietario){
        this.propietario= propietario
    }

    //Getter & Setter
    fun setCV(cv:Int){
        this.cv= cv;
    }
    fun getCV():Int{
        return this.cv;
    }

    //toString
    override fun toString(): String {
        return super.toString()
    }
}