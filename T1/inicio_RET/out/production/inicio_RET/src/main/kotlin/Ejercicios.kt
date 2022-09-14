fun main(arg: Array<String>) {

    var edad:Int= 0;

    println("Introduce tu edad: ");
    edad= readLine()!!.toInt();
    if(edad>=18){
        var max= -1;
        var min= 101;
        var sumatorio= 0;
        for(i in 1..10){
            var aleatorio= (1..100).random();
            sumatorio+= aleatorio;
            if (aleatorio>max)
                max=aleatorio;
            if (aleatorio<min)
                min=aleatorio
        }
        println("La suma de todos es ${sumatorio}");
        println("El mínimo de todos es ${min}");
        println("El máximo de todos es ${max}");
        println("La media de todos es ${sumatorio/10}");

    } else
        println("No eres mayor de edad")



}