class Jugador(id: Int, nombre:String, var posicion: String, var valor:Int): Persona(id, nombre) {
    // Funciones
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Posición: $posicion")
        println("Valor: $valor")
    }
}