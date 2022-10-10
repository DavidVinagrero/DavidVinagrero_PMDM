import model.Fantasy
import model.Jugador
import model.Participante
import model.Puntuacion

fun main() {
    // variables
    var plantilla1= ArrayList<Jugador>()
    var juego= Fantasy()

    var participante1: Participante= Participante(1,"Equipo1",plantilla1,0,10000000)
    var participante2: Participante= Participante(2,"Equipo2",plantilla1,0,10000000)
    var participante3: Participante= Participante(3,"Equipo3",plantilla1,0,10000000)
    var participante4: Participante= Participante(4,"Equipo4",plantilla1,0,10000000)

    // Programa
    participante1.ficharJugador(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
    participante1.ficharJugador(Jugador(2,"Ronald Araújo", "Defensa",4000000))
    participante1.ficharJugador(Jugador(3,"Eric García", "Defensa",1000000))
    participante1.ficharJugador(Jugador(4,"Pedri", "Mediocentro",5000000))
    participante1.ficharJugador(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
    participante1.ficharJugador(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))

    juego.anadirParticipantes(participante1, participante2, participante3, participante4)
    juego.listarParticipantes()
}