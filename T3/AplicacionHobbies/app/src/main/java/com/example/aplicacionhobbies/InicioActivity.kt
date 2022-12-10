package com.example.aplicacionhobbies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InicioActivity : AppCompatActivity() {
    private lateinit var botonInicio: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        this.botonInicio = findViewById(R.id.boton_inicio)
        botonInicio.setOnClickListener {
            var accionPasar = Intent(applicationContext, MainActivity::class.java)
            startActivity(accionPasar)
        }

    }
}