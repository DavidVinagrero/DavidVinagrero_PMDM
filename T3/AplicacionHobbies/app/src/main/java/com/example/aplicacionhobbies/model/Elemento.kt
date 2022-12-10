package com.example.aplicacionhobbies.model

class Elemento(
    var tipo: Int,
    var nombre: String,
    var detalle: String,
    var imagen: Int
) {
    override fun toString(): String {
        return nombre
    }
}