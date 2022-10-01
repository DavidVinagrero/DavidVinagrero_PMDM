package model

class Empresa(var nombre: String) {
    //Variables
    var trabajador: ArrayList<Trabajador> = ArrayList<Trabajador>()

    //Funciones
    fun registrarTrabajador() {
        var opcion: Int
        var nombre: String
        var apellido: String
        var dni: String
        var nss: Int
        var sueldo: Int
        var numeroPagas: Int
        var contratado: Boolean
        var acciones: Double
        var beneficio: Double
        println("\n 1. Registrar un asalariado\n 2. Registrar un autónomo\n 3. Registrar un jefe")
        opcion = readLine()!!.toInt()
        if (opcion == 1) {
            println("\nIntroduce los datos del asalariado")
            println("Nombre:")
            nombre = readLine().toString()
            println("Apellido:")
            apellido = readLine().toString()
            println("DNI:")
            dni = readLine().toString()
            println("NSS:")
            nss = readLine()!!.toInt()
            println("Sueldo:")
            sueldo = readLine()!!.toInt()
            println("Número de pagas:")
            numeroPagas = readLine()!!.toInt()
            println("Contratado (true o false)")
            contratado = readLine().toBoolean()
            val asalariado: Asalariado = Asalariado(nombre, apellido, dni, nss, sueldo, numeroPagas, contratado)
            trabajador.add(asalariado)
        } else if (opcion == 2) {
            println("\nIntroduce los datos del autónomo")
            println("Nombre:")
            nombre = readLine().toString()
            println("Apellido:")
            apellido = readLine().toString()
            println("DNI:")
            dni = readLine().toString()
            println("NSS:")
            nss = readLine()!!.toInt()
            println("Sueldo:")
            sueldo = readLine()!!.toInt()
            println("Contratado (true o false)")
            contratado = readLine().toBoolean()
            val autonomo: Autonomo = Autonomo(nombre, apellido, dni, nss, sueldo, contratado)
            trabajador.add(autonomo)
        } else {
            println("\nIntroduce los datos del jefe")
            println("Nombre:")
            nombre = readLine().toString()
            println("Apellido:")
            apellido = readLine().toString()
            println("DNI:")
            dni = readLine().toString()
            println("NSS:")
            nss = readLine()!!.toInt()
            println("Acciones:")
            acciones = readLine()!!.toDouble()
            println("Beneficio:")
            beneficio = readLine()!!.toDouble()
            var jefe: Jefe = Jefe(nombre, apellido, dni, nss, acciones, beneficio)
            trabajador.add(jefe)
        }
    }

    fun listarTrabajadores() {
        var arrayMutableKt=ArrayList<Trabajador>();
        var opcion: Int
        println(" 1. Mostrar asalariados\n 2. Mostrar autónomos\n 3. Mostrar jefes\n 4. Mostrar todos")
        opcion = readLine()!!.toInt()
        if (opcion == 1) {
            arrayMutableKt.forEach({elemento-> println(elemento)})
        } else {
            for (i in trabajador) {
                i.mostrarDatos()
            }
        }
    }
}

