

fun main(arg: Array<String>) {

    /*
    var nombre: String? = "Alverto";
    var edad: Int = 18;

    println("Introduce tu nombre: ");
    nombre = readLine();
    println("Introduce tu edad: ");
    edad = readLine()!!.toInt();
    //edad= readLine() as Int;


    //println(nombre2!!.length);
    println("Hola mi nombre es ${nombre} y tengo ${edad} años");
    println("La suma del numero 4 y el 2 es ${4 + 2}");
    */

    funcionArrays()

}

fun estructuraIf(x:Int):Unit{
    //Ejecuciones
        //No hay if ternario
        //La salida de un if la puedo guardar en una variable
    println("Indica tú edad: ");
    var numero:Int= readLine()!!.toInt();

    if(numero>18)
        println("Eres mayor de edad");
     else
        println("Eres menor de edad");

    println("Indica tu nombre");
    var nombre:String?= readLine();

    if(nombre!!.length >=5){
        println("Tu nombre es demasiado largo");
    }

    var valorNumerico:Int= if(nombre!!.length>5 && numero>10) 10 else 0;
    println(valorNumerico);
}

fun estructuraWhen() {
    //switch
    //case 1-> rango 1 y 5
    //no rango 1 y 5
    //salida de un método
    //switch vestido de if
    var numero:Int= 17;

    when(numero){
        1->{
            println("El caso es el valor 1");
        }
        in 2 .. 10 ->{
            println("El numero está en rango 2..10");
        }
        !in 1..10->{
            println("El número está en un rango no definido");
        }
    }
}

fun estructuraFor() {
    for (i in 1..4 step 2){
        println(i);
    }
    for (i in 10 downTo 5){
        println(i);
    }

    //(int)(Math.random()*21)
    //(1..200).random();
}

fun funcionArrays() {
    //String[] nombre= {"ads","fds"}-->lenght 2
    //int[] nombre= new int[2]--> lenght 2,0,0
    /*
    var arrayEmpty = emptyArray<String>();
    var arrayNull = arrayOfNulls<String>(5);
    var arrayCosas = arrayOf(1,2,3,4,5,6,true);
    var arrayNumeros = intArrayOf(1,2,3,4,5,6,7);*/

    var arrayNumeros: Array<Any>? = null;
    var arrayCosas: Array<Int?> = arrayOfNulls<Int>(5);
}