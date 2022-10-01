import model.Circulo
import model.Rectangulo
import model.Triangulo

fun main() {
    var option1 = 0
    var option2 = 0
    var option3 = 0
    var option4 = 0
    var circulo: Circulo= Circulo(0.0)
    var triangulo: Triangulo= Triangulo(0.0,0.0)
    var rectangulo: Rectangulo= Rectangulo(0.0,0.0)

    //Programa
    do {
        println("\n 1. Crear una figura\n 2. Operaciones con figuras\n 3. Salir")
        option1 = readLine()!!.toInt()

        if (option1 == 1) {
            println("\n 1. Crear un Círculo\n 2. Crear un rectángulo\n 3. Crear un Triángulo")
            option2 = readLine()!!.toInt()
            if (option2 == 1) {
                println("\n--Círculo--\nIntroduce el radio:")
                var radio: Double = readLine()!!.toDouble()
                circulo = Circulo(radio)
            } else if (option2 == 2) {
                println("\n--Rectángulo--\nIntroduce la base:")
                var base: Double = readLine()!!.toDouble()
                println("Introduce la altura:")
                var altura: Double = readLine()!!.toDouble()
                rectangulo = Rectangulo(base, altura)
            } else {
                println("\n--Triángulo--\nIntroduce la base:")
                var base: Double = readLine()!!.toDouble()
                println("Introduce la altura")
                var altura: Double = readLine()!!.toDouble()
                triangulo = Triangulo(base, altura)
            }
        }
        else if(option1==2) {
            println("\n 1. Calcular el área\n 2. Calcular el perímetro del rectángulo\n 3. Calcular el diámetro del círculo")
            option3= readLine()!!.toInt()
            if(option3== 1){
                println("\n 1. Área del círculo\n 2. Área del rectángulo\n 3. Área del triángulo")
                option4= readLine()!!.toInt()
                if(option4==1){
                    println("El área del círculo es "+circulo.calcularArea())
                } else if(option4==2){
                    println("El área del rectángulo es "+rectangulo.calcularArea())
                } else{
                    println("El área del triángulo es "+triangulo.calcularArea())
                }
            } else if(option3==2){
                println("El perímetro es "+rectangulo.calcularPerimetro())
            } else{
                println("El diámetro es "+circulo.calcularDiametro())
            }
        }
    } while (option1 != 3)
}