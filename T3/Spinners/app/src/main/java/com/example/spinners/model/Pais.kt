package com.example.spinners.model

class Pais(
    private var nombre: String,
    private var imagen: Int,
    private var numeroTitulos: Int,
    private var estrella: String
) {

    fun getNombre(): String {
        return this.nombre
    }

    fun getTitulos(): Int {
        return this.numeroTitulos
    }

    fun getImagen(): Int {
        return this.imagen
    }

    fun getEstrella(): String {
        return this.estrella
    }

    override fun toString(): String {
        return getNombre()
    }
}