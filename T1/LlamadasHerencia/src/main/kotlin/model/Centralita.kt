package model

import Llamada

class Centralita {

    // Variables
    var listaLlamadas: ArrayList<Llamada>

    // Constructores
    init {
        listaLlamadas = ArrayList()
    }

    // Funciones
    fun registrarLlamada(llamada: Llamada) {
        if (llamada is LlamadaNacional && (listaLlamadas.filter { it.javaClass.simpleName == "LlamadasNacional" }).size < 4){
            listaLlamadas.add(llamada)
        }
        println("Llamada registrada con datos:")
        llamada.mostrarDatos()
    }

    fun listarLlamadas() {
        listaLlamadas.forEachIndexed({ index, llamada ->
            llamada.mostrarDatos()
        })
    }

    fun mostrarCostesAcumulados() {
        var costeAcumulado: Double = 0.0
        listaLlamadas.forEach {
            costeAcumulado += it.coste
        }
        println("El coste acumulado es de: $costeAcumulado")
    }

    fun listarConFiltro(clase: String) {
        listaLlamadas.forEach {
            if (it::class.simpleName == clase) {
                it.mostrarDatos()
            }
        }
    }

    fun contarLlamadas() {

    }

    fun filtradoNumero() {

        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadasNacional" }).size)
        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadasProvincial" }).size)
        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadasLocal" }).size)

    }
}