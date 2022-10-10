package model

class CitaPaciente(var dia: Int, var mes: Int, var comentario: String, var medico: Medico) {

    // Funciones
    fun mostrarDatos() {
        println("Día: $dia")
        println("Mes: $mes")
        println("Comentario: $comentario")
        println("Médico: $medico")
    }


}