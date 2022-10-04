package model

class Asalariados(var name: String, var apellidos: String, var dnii: String, var sueldo: Double, var numPagos: Int, var contrato: Boolean):Trabajador(name,apellidos,dnii)