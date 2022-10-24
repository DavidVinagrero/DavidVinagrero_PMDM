package com.example.ejerciciocartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonMenor: ImageButton
    lateinit var botonMayor: ImageButton
    lateinit var nombreRecuperado: String
    lateinit var fondoAplicacion: ImageView
    private var cartas:Int = (Math.random()*14+1).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        instancias()
        recuperarDatos()
        acciones()
    }

    private fun acciones() {

        var apli: View= findViewById(android.R.id.content)

        var notification = Snackbar.make(
            apli,
            "Bienvenido, $nombreRecuperado",
            Snackbar.LENGTH_INDEFINITE
        )
        notification.setAction("Empezar") {
            botonMenor.setOnClickListener(this)
            botonMayor.setOnClickListener(this)
        }
        notification.show()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_mayor-> {

            }

            R.id.boton_menor->{

            }
        }
    }

    private fun recuperarDatos() {
        nombreRecuperado = intent.extras?.getString("nombre", "defecto") ?: "defecto"
    }

    private fun instancias() {
        botonMayor= findViewById(R.id.boton_mayor)
        botonMenor= findViewById(R.id.boton_menor)
        fondoAplicacion= findViewById(R.id.fondo)
    }
}
