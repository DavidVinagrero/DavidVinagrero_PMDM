import model.Coche
import model.Propietario

fun main(){
    var coche1:Coche= Coche("Mercedes","C220");
    var coche2:Coche=Coche("Ford","Fiesta","232H4h3KJ");
    coche1.mostrarDatos()
    coche1.calcularParMotor({aceleracion->aceleracion*2},10)
    coche2.calcularParMotor({aceleracion->aceleracion*1},10)
    coche1.asignarPropietario(Propietario("A","B","123"))

    println(coche1.propietario)
    /*
    coche1.cv=100
    println(coche1.cv)
    */
}