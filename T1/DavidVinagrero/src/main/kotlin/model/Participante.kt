package model

class Participante(id: Int, nombre: String, var plantilla: ArrayList<Jugador>, var puntos: Int, var presupuesto: Int) :
    Comun(id, nombre) {

    init {
        plantilla = ArrayList<Jugador>(6)
    }

    // Funciones
    override fun mostrarDatos() {
        super.mostrarDatos()
        plantilla.forEach {
            it.mostrarDatos()
        }
        println("Puntos: $puntos")
        println("Presupuesto: $presupuesto")
    }

    fun ficharJugador(jugador: Jugador) {
        var portero = 0
        var defensas = 0
        var medios = 0
        var delantero = 0
        if (jugador.valor < presupuesto) {
            for (i in 0..6) {
                if (jugador.posicion.equals("Portero") && portero == 0) {
                    plantilla.add(jugador)
                    presupuesto -= jugador.valor
                    portero += 1
                } else if (portero != 0) {
                    println("Solo puedes tener 1 portero")
                    break
                }
                if (jugador.posicion.equals("Defensa") && defensas <= 2) {
                    plantilla.add(jugador)
                    presupuesto -= jugador.valor
                    defensas+=1
                }else if(defensas>2){
                    println("Solo puedes tener 2 defensas")
                    break
                }
                if(jugador.posicion.equals("Mediocentro") && medios<=2){
                    plantilla.add(jugador)
                    presupuesto-= jugador.valor
                    medios+=1
                } else if(medios>2){
                    println("Solo puedes tener 2 mediocentros")
                    break
                }
                if(jugador.posicion.equals("Delantero") && delantero == 0){
                    plantilla.add(jugador)
                    presupuesto-= jugador.valor
                    delantero+=1
                } else if(delantero!=0){
                    println("Solo puedes tener 1 delantero")
                    break
                }
            }
        } else {
            println("Has agotado el presupuesto")
        }

    }

}