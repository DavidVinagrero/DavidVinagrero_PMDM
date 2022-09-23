fun main(){
    //funcionParametros(x="Hola",y=2);
    //funcionNormal();
    //funcionParamDefecto(5,"Hola",true);
    //funcionParamDefecto(5,"Hola");
    //funcionParamDefecto(numero=5,acierto=true);
    if(funcionRetorno(4,5)){
        println("La suma es mayor que diez");
    }else{
        println("La suma menor que diez");
    }

}

fun funcionNormal(){
    println("Función normal ejecutada");
}

fun funcionParametros(x: String, y: Int): Unit {
    println("Parámetro dos: $y");
    println("Parámetro uno: $x");
}

fun funcionParamDefecto(numero: Int, palabra: String, acierto: Boolean=false){
    println("El numero es: $numero");
    println("La palabra es: $palabra");
    println("El acierto es: $acierto");
}

fun funcionSuma(numeroUno: Int, numeroDos: Int)= println("${numeroUno+numeroDos}");

fun funcionRetorno(x: Int, y: Int): Boolean {
    if(x+y>10)
        return true;
    else
        return false;
}