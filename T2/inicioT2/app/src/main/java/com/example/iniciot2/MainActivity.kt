package com.example.iniciot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonInicial: Button
    lateinit var etiquetaSaludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Asocia la parte lógica y la gráfica
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonInicial.setOnClickListener({etiquetaSaludo.setText("Hola, primera app completa")})
    }

    private fun instancias(){
        this.botonInicial= findViewById(R.id.boton_inicial)
        this.etiquetaSaludo= findViewById(R.id.texto_saludo)
    }
}