import model.Asalariado
import model.Coche
import model.Propietario

fun main(){
    var coche1:Coche= Coche("Mercedes","C220");
    var coche2:Coche=Coche("Ford","Fiesta","232H4h3KJ");
    coche1.mostrarDatos()
    coche1.calcularParMotor({aceleracion->aceleracion*2},10)
    coche2.calcularParMotor({aceleracion->aceleracion*1},10)
    coche1.asignarPropietario(Propietario("A","B","123"))

    coche1.calcularVelocidad= {cc->
        println("Ejecución desde la clase coche")
        println("Deficición en la clase main")
        println("Obtenidos los cc del coche: $cc")}
    /*
    coche1.cv=100
    println(coche1.cv)
    */
}