package com.example.examendve_evaluacion.model

data class Producto(
    var id: Int? = null,
    var price: Int? = null,
    val stock: Int? = null,
    var thumbnail: String? = null,
    var title: String?= null
) {
}