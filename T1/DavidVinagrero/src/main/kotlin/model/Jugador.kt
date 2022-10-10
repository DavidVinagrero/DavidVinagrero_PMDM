package model

class Jugador(id: Int, nombre: String, var posicion: String, var valor: Int) : Comun(id, nombre) {
    // Variables
    var jugadores= ArrayList<Jugador>()

    // Funciones
    override fun mostrarDatos() {
        println("$nombre/  $valor - $posicion")
    }

    fun añadirJugadores(){
        jugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
        jugadores.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
        jugadores.add(Jugador(3,"Eric García", "Defensa",1000000))
        jugadores.add(Jugador(4,"Pedri", "Mediocentro",5000000))
        jugadores.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
        jugadores.add(Jugador(6,"Courtois", "Portero",3000000))
        jugadores.add(Jugador(7,"David Alaba", "Defensa",4000000))
        jugadores.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
        jugadores.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
        jugadores.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
        jugadores.add(Jugador(11,"Ledesma", "Portero",500000))
        jugadores.add(Jugador(12,"Juan Cala", "Defensa",300000))
        jugadores.add(Jugador(13,"Zaldua", "Defensa",400000))
        jugadores.add(Jugador(14,"Alex Fernández", "Mediocentro",700000))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        jugadores.add(Jugador(16,"Rajković", "Portero",300000))
        jugadores.add(Jugador(17,"Raíllo", "Defensa",200000))
        jugadores.add(Jugador(18,"Maffeo", "Defensa",300000))
        jugadores.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000))
        jugadores.add(Jugador(20,"Ángel", "Delantero", 300000))
        jugadores.add(Jugador(22,"Remiro", "Portero",1000000))
        jugadores.add(Jugador(23,"Elustondo", "Defensa",900000))
        jugadores.add(Jugador(24,"Zubeldia", "Defensa",800000))
        jugadores.add(Jugador(25,"Zubimendi", "Mediocentro",1000000))
        jugadores.add(Jugador(26,"Take Kubo", "Delantero", 800000))
    }
}