import model.*

fun main() {

    // Variables
    var centralita: Centralita= Centralita()
    centralita.registrarLlamada(LlamadaLocal(1,2,3,"Alcorcón"))
    centralita.registrarLlamada(LlamadaLocal(1,2,3, "Pozuelo"))
    centralita.registrarLlamada(LlamadaNacional(1,2,3,1))

    // Programa
    //centralita.listarLlamadas()
    centralita.mostrarCostesAcumulados()
}