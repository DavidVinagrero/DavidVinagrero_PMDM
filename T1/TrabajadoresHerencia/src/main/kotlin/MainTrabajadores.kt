import model.*

fun main() {
    //Variables
    var empresa: Empresa = Empresa("A.SL")
    var asalariado: Asalariado = Asalariado("Pedro", "Gómez", "1234567A", 1234, 12000, 12, true)
    var autonomo: Autonomo = Autonomo("Juan", "García", "1234567B", 12345, 2000, false)
    var jefe: Jefe = Jefe("Alverto", "Hernandez", "1234567C", 123456, 12.6, 10.0)
    var option: Int = 0;
    //Programa
    /*asalariado.mostrarDatos()
    println("\n")
    autonomo.mostrarDatos()
    println("\n")
    jefe.mostrarDatos()*/
    do {
        println("\n1. Registrar un trabajador\n"+"2. Mostrar trabajadores")
        option= readLine()!!.toInt()
        if(option==1){
            empresa.registrarTrabajador()
        }else{
            empresa.listarTrabajadores()
        }
    } while (option!=3)

}
