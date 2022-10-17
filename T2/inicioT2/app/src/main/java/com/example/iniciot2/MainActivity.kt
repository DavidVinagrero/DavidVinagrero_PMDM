package com.example.iniciot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonInicial: Button
    lateinit var etiquetaSaludo: TextView
    lateinit var editNombre: EditText
    lateinit var imagenEstado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("ciclo_vida","Ejecutando metodo onCreate")
        // Asocia la parte lógica y la gráfica
        setContentView(R.layout.activity_main)

        instancias()
        acciones()
    }

    private fun acciones() {
        botonInicial.setOnClickListener{
            if(!editNombre.text.isEmpty()){
                var notification= Snackbar.make(it,"¿Estás seguro, "+editNombre.text+"?",Snackbar.LENGTH_INDEFINITE)
                notification.setAction("Aceptar",{
                    //etiquetaSaludo.setText(editNombre.text)
                    //editNombre.setText("")
                    imagenEstado.setImageResource(R.drawable.shocked)
                })
                notification.show()
            } else{
                Log.v("edit_nombre","Texto vacío")
                Toast.makeText(applicationContext,"Texto vacío",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun instancias(){
        this.botonInicial= findViewById(R.id.boton_inicial)
        this.etiquetaSaludo= findViewById(R.id.texto_saludo)
        this.editNombre= findViewById(R.id.edit_nombre)
        this.imagenEstado= findViewById(R.id.imagen_estado)
    }

    override fun onStart() {
        Log.v("ciclo_vida","Ejecutando metodo onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.v("ciclo_vida","Ejecutando metodo onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.v("ciclo_vida","Ejecutando metodo onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("ciclo_vida","Ejecutando metodo onStop")
        super.onStop()
    }
}