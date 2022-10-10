package model

class Medico(nombre: String, apellido: String, dni: String, var especialidad: String, var numeroColegiado: Int) :
    Persona(nombre, apellido, dni) {

        // Variables
        lateinit var listaCitas: ArrayList<String>

    // Funciones
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Número colegiado: $numeroColegiado")
        println("Especialidad: $especialidad")
        if(!listaCitas.isEmpty()){
            listaCitas.forEach {
                println("Día: ${it.split("/")[0]}")
                println("Mes: ${it.split("/")[1]}")
            }
        }
    }
}