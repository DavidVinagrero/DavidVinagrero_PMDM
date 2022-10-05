package model

class Paciente(nombre: String, apellido: String, dni: String, var nss: Int) :
    Persona(nombre, apellido, dni) {

    // Variables
    lateinit var listaCitas: ArrayList<CitaPaciente>

    // Constructores


    // Funciones
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("NSS: $nss")
    }
}