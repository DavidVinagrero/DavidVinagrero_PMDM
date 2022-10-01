package model

class Circulo(var radio: Double) {

    //Funciones
    fun calcularArea(): Double {
        return (Math.PI * (Math.pow(radio, 2.0)))
    }

    fun calcularDiametro(): Double {
        return 2 * radio
    }
}