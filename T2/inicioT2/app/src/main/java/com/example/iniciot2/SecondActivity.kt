package com.example.iniciot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var nombreRecuperado: String
    private var edadRecuperada: Int = 0
    private lateinit var correoRecuperado: String
    private lateinit var textoNombre:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        reucperarDatos()
        iniciarUI()

    }

    private fun instancias() {
        textoNombre= findViewById(R.id.texto_recepcion)
    }

    private fun reucperarDatos() {
        nombreRecuperado = intent.extras?.getString("nombre", "defecto") ?: "defecto"
        edadRecuperada = intent.extras?.getInt("edad", 16) ?: 0
        correoRecuperado = intent.extras?.getString("correo", "correo@defecto.com") ?: "sin correo"
    }

    private fun iniciarUI() {
        Log.v("datos_recuperados", nombreRecuperado)
        Log.v("datos_recuperados", nombreRecuperado)
        Log.v("datos_recuperados", nombreRecuperado)
        textoNombre.setText(nombreRecuperado+resources.getString(R.string.saludo_completo))
    }
}
