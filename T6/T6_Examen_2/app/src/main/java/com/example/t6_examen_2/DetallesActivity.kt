package com.example.t6_examen_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.t6_examen_2.model.Juego

class DetallesActivity : AppCompatActivity() {

    lateinit var etiquetaNombre: TextView
    lateinit var etiquetaDescripcion: TextView
    lateinit var etiquetaPlataforma: TextView
    lateinit var etiquetaPrecio: TextView
    lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        instancias()
        recuperarDatos()
    }

    private fun instancias() {
        this.etiquetaNombre = findViewById(R.id.etiqueta_nombre)
        this.etiquetaDescripcion = findViewById(R.id.etiqueta_descripcion)
        this.etiquetaPlataforma = findViewById(R.id.etiqueta_plataforma)
        this.etiquetaPrecio = findViewById(R.id.etiqueta_precio)
        this.imagen = findViewById(R.id.imagen_juego)
    }

    private fun recuperarDatos() {
        var nombreRecuperado = intent.extras?.getString("nombre", "defecto") ?: "defecto"
        var descripcionRecuperado = intent.extras?.getString("descripcion", "defecto") ?: "defecto"
        var plataformaRecuperado = intent.extras?.getString("plataforma", "defecto") ?: "defecto"
        var imagenRecuperado = intent.extras?.getInt("imagen", 0) ?: 0
        var precioRecuperado = intent.extras?.getDouble("precio", 0.0) ?: 0.9

        etiquetaNombre.text = nombreRecuperado
        etiquetaPrecio.text = precioRecuperado.toString()+" €"
        etiquetaDescripcion.text = descripcionRecuperado
        etiquetaPlataforma.text = plataformaRecuperado
        imagen.setImageResource(imagenRecuperado)

    }
}