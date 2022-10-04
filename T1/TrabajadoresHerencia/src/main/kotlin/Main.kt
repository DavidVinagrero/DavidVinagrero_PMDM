import model.*

fun main() {

    var tipoEmp: String;
    var trabajadores = arrayListOf<Trabajador>()
    var empresa:Empresa = Empresa()
    var nombre: String;
    var apellido: String;
    var dni: String;
    var acciones: Int;
    var beneficio: Double;
    var sueldo: Double
    var sueldoAnual: Double
    var numPagos: Int
    var contrato: Boolean = false;
    var numJefe: Int = 0;
    empresa.trabajadores=trabajadores;


    var opcion: Int;
    opcion = readLine()!!.toInt();

    println("Gestión empresarial: ")
    println("Que desea hacer: ")

    println("Opción 1: Registrar trabajador ")
    println("Opción 2: Listar trabajadores ")
    println("Opción 3: Mostrar datos de  trabajador ")
    println("Opción 4: Despedir trabajador ")


    when (opcion) {
        1 -> {
            println("Introduce un asalariado, un autonomo o un jefe ")
            tipoEmp = readln()
            if(tipoEmp == "asalariado"){
                println("Introduce un nombre, un apellido y un dni ")
                println("Introduce un nombre")
                nombre= readln()
                println("Introduce un apellido ")
                apellido= readln()
                println("Introduce un dni ")
                dni= readln()
                println("Introduce el sueldo")
                sueldo= readln().toDouble();
                println("Introduce el numero de pagos")
                numPagos= readln().toInt();
                contrato= true;
                for (item in trabajadores) {
                    if(empresa.trabajadores.equals(dni)){
                        println("El trabajador ya se encuentra en la empresa, vuelve a probar")
                        break
                    }
                }
                var asalariado: Asalariados = Asalariados(nombre,apellido,dni,sueldo, numPagos, contrato);
                empresa.registrarTrabajador(asalariado)
            }
            if(tipoEmp == "jefe" && numJefe==0){
                println("Introduce un nombre, un apellido y un dni ")
                println("Introduce un nombre")
                nombre= readln()
                println("Introduce un apellido ")
                apellido= readln()
                println("Introduce un dni ")
                dni= readln()
                println("Introduce las acciones ")
                acciones= readln().toInt();
                println("Introduce el beneficio")
                beneficio= readln().toDouble();


                var jefe: Jefe = Jefe(nombre,apellido,dni,acciones,beneficio);
                empresa.registrarTrabajador(jefe)
                numJefe++
            }else{
                println("La empresa ya tiene un jefe, pruebe de nuevo")
            }
            if(tipoEmp == "autonomo"){
                println("Introduce un nombre, un apellido y un dni ")
                println("Introduce un nombre")
                nombre= readln()
                println("Introduce un apellido ")
                apellido= readln()
                println("Introduce un dni ")
                dni= readln()
                for (item in trabajadores) {
                    if(empresa.trabajadores.equals(dni)){
                    println("El trabajador ya se encuentra en la empresa, vuelve a probar")
                        break
                    }
                }
                println("Introduce el sueldo anual")
                sueldoAnual= readln().toDouble();
                contrato= true;
                var autonomo: Autonomo = Autonomo(nombre,apellido,dni,sueldoAnual,contrato);
                empresa.registrarTrabajador(autonomo)
            }
        }

        2 -> {
            empresa.listarEmpleados()
        }
        3 -> {
            println("Introduce el dni de un empleados")
            dni= readln()
            empresa.listarEmpleados(dni)
        }
        4 -> {
            println("Introduce el dni de un empleado que se quiera despedir")
            dni= readln()
            empresa.despedirEmpleados(dni)
        }
    }
}

