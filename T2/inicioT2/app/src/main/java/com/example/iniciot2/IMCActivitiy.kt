package com.example.iniciot2

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
                if(validarSexo() && validarPeso()){

                }
            }
        }
    }

    private fun validarPeso(): Boolean {
        
    }

    private fun validarSexo(): Boolean {
        if(etiquetaSexo.text.equals("Hombre") || etiquetaSexo.text.equals("Mujer")){
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