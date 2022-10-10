package model

class Fantasy {
    // Variables
    var listaParticipantes= ArrayList<Participante>(4)
    var listaJugadores= ArrayList<Jugador>()


    // Funciones
    fun anadirParticipantes(participante1: Participante, participante2: Participante, participante3: Participante, participante4: Participante){
        listaParticipantes.add(participante1)
        listaParticipantes.add(participante2)
        listaParticipantes.add(participante3)
        listaParticipantes.add(participante4)
    }
    fun iniciarJuego(){

    }

    fun listarParticipantes(){
        listaParticipantes.forEach {
            it.mostrarDatos()
        }
    }

    fun validarPresupuesto(participante: Participante): Boolean {
        if (participante.presupuesto >= 0 && participante.presupuesto <= 10000000) {
            return true
        }
        return false
    }

    fun validarPlantilla(participante: Participante): Boolean {
        if (participante.plantilla.size == 6){
            return true
        }
        return false
    }
}