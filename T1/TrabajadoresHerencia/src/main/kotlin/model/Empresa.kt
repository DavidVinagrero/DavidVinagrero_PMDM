package model

class Empresa {

    var trabajadores = arrayListOf<Trabajador>()

    fun registrarTrabajador(trabajador: Trabajador){
        trabajadores.add(trabajador)
    }

    fun listarEmpleados(){
        for ((index,item) in trabajadores.withIndex()) {
            trabajadores[index].mostrarTrabajador()
        }
        }
    fun listarEmpleados(dni:String){
        for ((index,item) in trabajadores.withIndex()) {
            if(trabajadores[index].dni==dni)
            trabajadores[index].mostrarTrabajador()
        }
    }
    fun despedirEmpleados(dni:String){
        for ((index,item) in trabajadores.withIndex()) {
            if(trabajadores[index].dni==dni)
                trabajadores.remove(trabajadores[index])
        }
    }

}