import model.Asalariado
import model.Autonomo
import model.Jefe

    fun main(){
        //Variables
        var asalariado: Asalariado= Asalariado("Pedro","Gómez","1234567A",34000,12,true)
        var autonomo: Autonomo= Autonomo("Juan","García","1234567B",35000,false)
        var jefe: Jefe= Jefe("Alverto","Hernandez","1234567C",30.0,12.6)

        //Programa
        asalariado.mostrarDatos()
        println("\n")
        autonomo.mostrarDatos()
        println("\n")
        jefe.mostrarDatos()
    }
