package model

class Rectangulo(var base: Double, var altura: Double) {

    //Funciones
    fun calcularArea(): Double {
        return base * altura
    }

    fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }

}