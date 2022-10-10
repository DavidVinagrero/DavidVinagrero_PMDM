class Fantasy {
    // Variables
    lateinit var listaParticipantes: ArrayList<Participante>
    lateinit var listaJugadores: ArrayList<Jugador>

    // Constructor
    init {
        listaJugadores= ArrayList()
        listaParticipantes= ArrayList()
    }

    // Funciones
    fun anadirJugadores(){
        listaJugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
        listaJugadores.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
        listaJugadores.add(Jugador(3,"Eric García", "Defensa",1000000))
        listaJugadores.add(Jugador(4,"Pedri", "Mediocentro",5000000))
        listaJugadores.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
        listaJugadores.add(Jugador(6,"Courtois", "Portero",3000000))
        listaJugadores.add(Jugador(7,"David Alaba", "Defensa",4000000))
        listaJugadores.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
        listaJugadores.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
        listaJugadores.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
        listaJugadores.add(Jugador(11,"Ledesma", "Portero",500000))
        listaJugadores.add(Jugador(12,"Juan Cala", "Defensa",300000))
        listaJugadores.add(Jugador(13,"Zaldua", "Defensa",400000))
        listaJugadores.add(Jugador(14,"Alex Fernández", "Mediocentro",700000))
        listaJugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        listaJugadores.add(Jugador(16,"Rajković", "Portero",300000))
        listaJugadores.add(Jugador(17,"Raíllo", "Defensa",200000))
        listaJugadores.add(Jugador(18,"Maffeo", "Defensa",300000))
        listaJugadores.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000))
        listaJugadores.add(Jugador(20,"Ángel", "Delantero", 300000))
        listaJugadores.add(Jugador(22,"Remiro", "Portero",1000000))
        listaJugadores.add(Jugador(23,"Elustondo", "Defensa",900000))
        listaJugadores.add(Jugador(24,"Zubeldia", "Defensa",800000))
        listaJugadores.add(Jugador(25,"Zubimendi", "Mediocentro",1000000))
        listaJugadores.add(Jugador(26,"Take Kubo", "Delantero", 800000))
    }

    fun anadirParticipantes(participante: Participante){
        this.listaParticipantes.add(participante)
    }

    fun getJugadoresCaros(){
        this.listaJugadores.filter({ it.valor >= 30000000 } ).forEach{it.mostrarDatos()}
    }
    

}