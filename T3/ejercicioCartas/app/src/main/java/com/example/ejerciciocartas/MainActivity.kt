package com.example.ejerciciocartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etiquetaNombre: EditText
    lateinit var botonComenzar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        iniciar()
    }

    private fun iniciar() {
            botonComenzar.setOnClickListener{
                if(etiquetaNombre.text.toString()!=""){
                var accionPasar = Intent(applicationContext, GameActivity::class.java)
                var datosPasar: Bundle = Bundle()
                datosPasar.putString("nombre", etiquetaNombre.text.toString())
                accionPasar.putExtras(datosPasar)

                startActivity(accionPasar)
                } else{
                    Log.v("edit_nombre", "Nombre vacío")
                    Toast.makeText(applicationContext, "!! Introduce un nombre ¡¡", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun instancias() {
        this.etiquetaNombre= findViewById(R.id.etiqueta_nombre)
        this.botonComenzar= findViewById(R.id.boton_comenzar)
    }
}