package com.example.ejerciciocartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private var puntos: Int = 0
    private var cartas: Int = (Math.random() * 14 + 1).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        instancias()
        recuperarDatos()
        acciones()
    }

    private fun acciones() {

        var apli: View = findViewById(android.R.id.content)

        var notification = Snackbar.make(
            apli,
            "Bienvenido, $nombreRecuperado",
            Snackbar.LENGTH_INDEFINITE
        )
        notification.setAction("Empezar") {
            when(cartas){
                1->{fondoAplicacion.setImageResource(R.drawable.c1)}
                2->{fondoAplicacion.setImageResource(R.drawable.c2)}
                3->{fondoAplicacion.setImageResource(R.drawable.c3)}
                4->{fondoAplicacion.setImageResource(R.drawable.c4)}
                5->{fondoAplicacion.setImageResource(R.drawable.c5)}
                6->{fondoAplicacion.setImageResource(R.drawable.c6)}
                7->{fondoAplicacion.setImageResource(R.drawable.c7)}
                8->{fondoAplicacion.setImageResource(R.drawable.c8)}
                9->{fondoAplicacion.setImageResource(R.drawable.c9)}
                10->{fondoAplicacion.setImageResource(R.drawable.c10)}
                11->{fondoAplicacion.setImageResource(R.drawable.c11)}
                12->{fondoAplicacion.setImageResource(R.drawable.c12)}
                13->{fondoAplicacion.setImageResource(R.drawable.c13)}
            }
            botonMenor.setOnClickListener(this)
            botonMayor.setOnClickListener(this)
        }
        notification.show()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            // Escuchador del boton mayor
            R.id.boton_mayor -> {
                // Variable auxiliar para comparar el antiguo valor de cartas por uno nuevo
                var aux: Int = cartas
                cartas = (Math.random() * 13 + 1).toInt()

                // Bucle para confirmar que el valor nunca será igual
                while(aux==cartas){
                    cartas = (Math.random() * 13 + 1).toInt()
                }

                // Mecánica si aciertas
                if (aux < cartas){
                    puntos++
                    when(cartas){
                        1->{fondoAplicacion.setImageResource(R.drawable.c1)}
                        2->{fondoAplicacion.setImageResource(R.drawable.c2)}
                        3->{fondoAplicacion.setImageResource(R.drawable.c3)}
                        4->{fondoAplicacion.setImageResource(R.drawable.c4)}
                        5->{fondoAplicacion.setImageResource(R.drawable.c5)}
                        6->{fondoAplicacion.setImageResource(R.drawable.c6)}
                        7->{fondoAplicacion.setImageResource(R.drawable.c7)}
                        8->{fondoAplicacion.setImageResource(R.drawable.c8)}
                        9->{fondoAplicacion.setImageResource(R.drawable.c9)}
                        10->{fondoAplicacion.setImageResource(R.drawable.c10)}
                        11->{fondoAplicacion.setImageResource(R.drawable.c11)}
                        12->{fondoAplicacion.setImageResource(R.drawable.c12)}
                        13->{fondoAplicacion.setImageResource(R.drawable.c13)}
                    }
                }
                // Mecánica si fallas
                else{
                    // Crear snackbar
                    var notification = Snackbar.make(
                        p0,
                        "Has perdido $nombreRecuperado,"+" has conseguido $puntos puntos",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    notification.setAction("Aceptar") {
                        finish()
                    }
                    notification.show()
                }
            }
            // Escuchador del boton menor
            R.id.boton_menor -> {
                // Variable auxiliar para comparar el antiguo valor de cartas por uno nuevo
                var aux: Int = cartas
                cartas = (Math.random() * 13 + 1).toInt()

                // Bucle para confirmar que el valor nunca será igual
                while(aux==cartas){
                    cartas = (Math.random() * 13 + 1).toInt()
                }

                // Mecánica si aciertas
                if (aux > cartas){
                    puntos++
                    when(cartas){
                        1->{fondoAplicacion.setImageResource(R.drawable.c1)}
                        2->{fondoAplicacion.setImageResource(R.drawable.c2)}
                        3->{fondoAplicacion.setImageResource(R.drawable.c3)}
                        4->{fondoAplicacion.setImageResource(R.drawable.c4)}
                        5->{fondoAplicacion.setImageResource(R.drawable.c5)}
                        6->{fondoAplicacion.setImageResource(R.drawable.c6)}
                        7->{fondoAplicacion.setImageResource(R.drawable.c7)}
                        8->{fondoAplicacion.setImageResource(R.drawable.c8)}
                        9->{fondoAplicacion.setImageResource(R.drawable.c9)}
                        10->{fondoAplicacion.setImageResource(R.drawable.c10)}
                        11->{fondoAplicacion.setImageResource(R.drawable.c11)}
                        12->{fondoAplicacion.setImageResource(R.drawable.c12)}
                        13->{fondoAplicacion.setImageResource(R.drawable.c13)}
                    }
                }
                // Mecánica si fallas
                else{
                    // Crear snackbar
                    var notification = Snackbar.make(
                        p0,
                        "Has perdido $nombreRecuperado,"+" has conseguido $puntos puntos",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    notification.setAction("Aceptar") {
                        finish()
                    }
                    notification.show()
                }
            }
        }
    }

    private fun recuperarDatos() {
        nombreRecuperado = intent.extras?.getString("nombre", "defecto") ?: "defecto"
    }

    private fun instancias() {
        botonMayor = findViewById(R.id.boton_mayor)

        botonMenor = findViewById(R.id.boton_menor)
        fondoAplicacion = findViewById(R.id.fondo)
    }
}
