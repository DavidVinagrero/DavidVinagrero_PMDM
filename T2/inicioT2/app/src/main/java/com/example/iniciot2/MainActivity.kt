package com.example.iniciot2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonInicial: Button
    lateinit var etiquetaSaludo: TextView
    lateinit var editNombre: EditText
    lateinit var imagenEstado: ImageView
    lateinit var botonPasar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("ciclo_vida", "Ejecutando metodo onCreate")
        // Asocia la parte lógica y la gráfica
        setContentView(R.layout.activity_main)

        instancias()
        acciones()
    }

    private fun acciones() {
        botonInicial.setOnClickListener(this)
        botonPasar.setOnClickListener(this)
        /*
        botonPasar.setOnClickListener({view:View->
            Toast.makeText(applicationContext,"Pulsado dos", Toast.LENGTH_SHORT).show()})*/
    }

    private fun instancias() {
        this.botonInicial = findViewById(R.id.boton_inicial)
        this.etiquetaSaludo = findViewById(R.id.texto_saludo)
        this.editNombre = findViewById(R.id.edit_nombre)
        this.imagenEstado = findViewById(R.id.imagen_estado)
        this.botonPasar = findViewById(R.id.boton_pasar)
    }

    override fun onStart() {
        Log.v("ciclo_vida", "Ejecutando metodo onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.v("ciclo_vida", "Ejecutando metodo onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.v("ciclo_vida", "Ejecutando metodo onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("ciclo_vida", "Ejecutando metodo onStop")
        super.onStop()
    }

    override fun onClick(p0: View?) {
        // ejecuta cualquier elemento que tiene listener se pulsa
        when (p0!!.id) {
            // Boton pasar
            R.id.boton_pasar -> {
                // generar INTENT --> origen (la pantalla - context)
                var accionPasar = Intent(applicationContext, SecondActivity::class.java)
                var datosPasar: Bundle = Bundle()
                datosPasar.putString("nombre", editNombre.text.toString())
                datosPasar.putInt("edad", 10)
                accionPasar.putExtras(datosPasar)

                startActivity(accionPasar)
            }

            // Boton inicial
            R.id.boton_inicial -> {
                if (!editNombre.text.isEmpty()) {
                    var notification = Snackbar.make(
                        p0,
                        "¿Estás seguro, " + editNombre.text + "?",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    notification.setAction("Aceptar", {
                        //etiquetaSaludo.setText(editNombre.text)
                        //editNombre.setText("")
                        imagenEstado.setImageResource(R.drawable.shocked)
                    })
                    notification.show()
                } else {
                    Log.v("edit_nombre", "Texto vacío")
                    Toast.makeText(applicationContext, "Texto vacío", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}