package model

class CentroMedico {
    // Variables
    lateinit var listaMedicos: ArrayList<Medico>
    lateinit var listaPacientes: ArrayList<Paciente>

    // Constructores
    init {
        listaMedicos = ArrayList<Medico>()
        listaPacientes = ArrayList<Paciente>()
    }

    // Funciones
    fun contratarMedicos() {
        listaMedicos.add(Medico("Nick", "traumatología", "Rivera", "001", 1))
        listaMedicos.add(Medico("Hannibal", "digestivo", "Lecter", "002", 2))
        listaMedicos.add(Medico("Sam", "psiquiatría", "Owens", "003", 3))
        listaMedicos.add(Medico("Martin", "general", "Brenner", "004", 4))
        listaMedicos.add(Medico("Stephen", "cirugía", "Strange", "005", 5))
    }

    private fun existePaciente(nss: Int): Int {
        var existe = -1
        listaPacientes.forEach {
            if (it.nss == nss) {
                return existe
            }
        }
        return existe+1
    }
 b 
    fun registrarPaciente(paciente: Paciente) {
        if (existePaciente(paciente.nss) != -1) {
            listaPacientes.add(paciente)
        } else{
            println("El paciente ya existe")
        }
    }

    fun listarMedicos() {
        listaMedicos.forEach {
            it.mostrarDatos()
        }
    }

    fun listarPacientes() {
        listaPacientes.forEach {
            it.mostrarDatos()
        }
    }
}