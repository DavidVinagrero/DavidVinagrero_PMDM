package model

data class Jefe(var name: String, var apellidos:String, var dnii: String, var acciones: Int, var beneficio:Double):Trabajador(name,apellidos,dnii){

    val trabajadores = arrayListOf<Trabajador>()
    fun despedirTrabajador(trabajador: Trabajador){
        trabajadores.remove(trabajador)
    }
    fun contratarTrabajador(trabajador: Trabajador){
        trabajadores.add(trabajador)
    }



}