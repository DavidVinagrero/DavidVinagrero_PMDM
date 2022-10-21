package com.example.iniciot2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class IMCActivitiy : AppCompatActivity() {

    lateinit var botonCalcular: Button
    lateinit var etiquetaAltura: EditText
    lateinit var etiquetaPeso: EditText
    lateinit var etiquetaSexo: EditText
    lateinit var imagenResultado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        instancias()
        acciones()
    }

    private fun acciones(){
        botonCalcular.setOnClickListener{
            if(etiquetaSexo.text.isEmpty() || etiquetaPeso.text.isEmpty() || etiquetaAltura.text.isEmpty()){
                Log.v("edit_","Campo/s vacio ")
                Toast.makeText(applicationContext,"Ninguno de los campos puede estar vacío",Toast.LENGTH_SHORT).show()
            } else{
                if(validarSexo() && validarPeso() && validarAltura()){
                        // IMC = peso (kg) / altura2 (m)
                    var imc= etiquetaPeso.text.toString().toDouble()/ Math.pow(etiquetaAltura.text.toString().toDouble(),2.0)
                    Log.v("imc_resultado", imc.toString())

                    var accionPasar= Intent(applicationContext, DetailsActivity::class.java)
                    var datosPasar: Bundle= Bundle()
                    datosPasar.putDouble("imc", imc.toDouble())
                    datosPasar.putString("sexo",etiquetaSexo.text.toString())
                    accionPasar.putExtras(datosPasar)

                    startActivity(accionPasar)
                }
            }
        }
    }

    private fun validarAltura(): Boolean {
        if(etiquetaAltura.text.toString().toDouble() in 1.5..2.2){
            return true
        } else{
            Toast.makeText(applicationContext,"La altura está fuera de rango", Toast.LENGTH_SHORT).show()
            return false
        }
    }
    private fun validarPeso(): Boolean {
        if(etiquetaPeso.text.toString().toDouble() in 20.0..130.0){
            return true
        } else{
            Toast.makeText(applicationContext,"El peso está fuera de rango", Toast.LENGTH_SHORT).show()
            return false
        }
    }
    private fun validarSexo(): Boolean {
        if(etiquetaSexo.text.toString().equals("Hombre") || etiquetaSexo.text.toString().equals("Mujer")
            || etiquetaSexo.text.toString().equals("hombre") || etiquetaSexo.text.toString().equals("mujer")){
            return true
        } else{
            Log.v("edit_sexo","Campo incorrecto")
            Toast.makeText(applicationContext,"El sexo debe ser Hombre o Mujer",Toast.LENGTH_SHORT).show()
            return false
        }
        return false
    }

    private fun instancias(){
        this.botonCalcular= findViewById(R.id.boton_calcular)
        this.etiquetaPeso= findViewById(R.id.etiqueta_peso)
        this.etiquetaAltura= findViewById(R.id.etiqueta_altura)
        this.etiquetaSexo= findViewById(R.id.etiqueta_sexo)
        this.imagenResultado= findViewById(R.id.imagen_final)
    }
}