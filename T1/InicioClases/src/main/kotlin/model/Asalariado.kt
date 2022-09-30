package model

class Asalariado(nombre: String, apellido: String, edad: Int, var correo: String) : Persona(nombre, apellido, edad) {

    //Variables
    private var NSS: Int=0;
    private var salario:Int?= null;
    private var pagas:Int= 12;

    //Constructores
    constructor(nombre: String, apellido: String, edad: Int, correo: String, nss: Int, salario: Int): this(nombre, apellido, edad, correo){
        this.NSS= NSS
        this.salario= salario
    }

    //Funciones
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("NSS: $NSS")
        println("Salario: $salario")
        println("Correo: $correo")
    }

    //Métodos
    fun calcularSalario(retencion:Int){
        var retencionesCalculadas:Double= (this.salario!!*(retencion/100)).toDouble()
        println("El salario neto anual es ${this.salario!!-retencionesCalculadas}")
        println("El salario neto mensual es ${(this.salario!!-retencionesCalculadas)/this.pagas}")
    }

    //Getter y Setter
    fun setNSS(nss: Int){
        this.NSS= NSS
    }

    fun getNSS():Int{
        return this.NSS
    }

    fun getSalario():Int?{
        return this.salario
    }

    fun setSalario(salario: Int){
        this.salario= salario;
    }
}