package model

data class Autonomo(var name:String, var apellidos: String, var dnii: String, var sueldo: Double, var contratado: Boolean):Trabajador(name,apellidos,dnii)