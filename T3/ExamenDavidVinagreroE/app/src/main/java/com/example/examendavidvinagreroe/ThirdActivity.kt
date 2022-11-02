package com.example.examendavidvinagreroe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    lateinit var etiquetaNombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        instancias()

        acciones()
    }

    private fun acciones() {

    }

    private fun instancias() {
        this.etiquetaNombre= findViewById(R.id.etiqueta_nombre_resultado)
    }
}