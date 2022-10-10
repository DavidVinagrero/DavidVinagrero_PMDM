package model

class Puntuacion(id: Int, nombre: String, var puntos: Int) : Comun(id, nombre) {
    // Variables
    var puntuaciones= ArrayList<Puntuacion>()


    // Funciones
    fun añadirPuntuaciones(){
        puntuaciones.add(Puntuacion(1,"Marc-André ter Stegen", 10))
        puntuaciones.add(Puntuacion(2,"Ronald Araújo",0))
        puntuaciones.add(Puntuacion(3,"Eric García",3))
        puntuaciones.add(Puntuacion(4,"Pedri",23))
        puntuaciones.add(Puntuacion(5,"Robert Lewandowski",15))
        puntuaciones.add(Puntuacion(6,"Courtois",1))
        puntuaciones.add(Puntuacion(7,"David Alaba",5))
        puntuaciones.add(Puntuacion(8,"Jesús Vallejo",10))
        puntuaciones.add(Puntuacion(9,"Luka Modric",5))
        puntuaciones.add(Puntuacion(10,"Karim Benzema",10))
        puntuaciones.add(Puntuacion(11,"Ledesma",6))
        puntuaciones.add(Puntuacion(12,"Juan Cala",3))
        puntuaciones.add(Puntuacion(13,"Zaldua",6))
        puntuaciones.add(Puntuacion(14,"Alez Fernández",9))
        puntuaciones.add(Puntuacion(15, "Choco Lozano", 4))
        puntuaciones.add(Puntuacion(16,"Rajković",3))
        puntuaciones.add(Puntuacion(17,"Raíllo",6))
        puntuaciones.add(Puntuacion(18,"Maffeo",0))
        puntuaciones.add(Puntuacion(19,"Ruiz de Galarreta",7))
        puntuaciones.add(Puntuacion(20,"Ángel", 4))
        puntuaciones.add(Puntuacion(21,"Remiro",3))
        puntuaciones.add(Puntuacion(22,"Elustondo",5))
        puntuaciones.add(Puntuacion(23,"Zubeldia",6))
        puntuaciones.add(Puntuacion(24,"Zubimendi",7))
        puntuaciones.add(Puntuacion(25,"Take Kubo", 4))
        // puntuaciones segunda jornada
        puntuaciones.add(Puntuacion(1,"Marc-André ter Stegen", 5))
        puntuaciones.add(Puntuacion(2,"Ronald Araújo",5))
        puntuaciones.add(Puntuacion(3,"Eric García",4))
        puntuaciones.add(Puntuacion(4,"Pedri",10))
        puntuaciones.add(Puntuacion(5,"Robert Lewandowski",10))
        puntuaciones.add(Puntuacion(6,"Courtois",1))
        puntuaciones.add(Puntuacion(7,"David Alaba",7))
        puntuaciones.add(Puntuacion(8,"Jesús Vallejo",5))
        puntuaciones.add(Puntuacion(9,"Luka Modric",15))
        puntuaciones.add(Puntuacion(10,"Karim Benzema",0))
        puntuaciones.add(Puntuacion(11,"Ledesma",9))
        puntuaciones.add(Puntuacion(12,"Juan Cala",3))
        puntuaciones.add(Puntuacion(13,"Zaldua",3))
        puntuaciones.add(Puntuacion(14,"Alez Fernández",7))
        puntuaciones.add(Puntuacion(15, "Choco Lozano", 2))
        puntuaciones.add(Puntuacion(16,"Rajković",8))
        puntuaciones.add(Puntuacion(17,"Raíllo",9))
        puntuaciones.add(Puntuacion(18,"Maffeo",2))
        puntuaciones.add(Puntuacion(19,"Ruiz de Galarreta",10))
        puntuaciones.add(Puntuacion(20,"Ángel", 4))
        puntuaciones.add(Puntuacion(21,"Remiro",5))
        puntuaciones.add(Puntuacion(22,"Elustondo",8))
        puntuaciones.add(Puntuacion(23,"Zubeldia",9))
        puntuaciones.add(Puntuacion(24,"Zubimendi",11))
        puntuaciones.add(Puntuacion(25,"Take Kubo", 10))
    }

}