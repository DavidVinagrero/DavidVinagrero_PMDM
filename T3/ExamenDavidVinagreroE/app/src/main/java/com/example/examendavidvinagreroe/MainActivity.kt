package com.example.examendavidvinagreroe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonComenzar: Button
    lateinit var etiquetaNombre: EditText
    lateinit var etiquetaApellido: EditText
    lateinit var switchComenzar: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonComenzar.setOnClickListener(this)
    }

    private fun instancias() {
        this.botonComenzar = findViewById(R.id.boton_comenzar)
        this.etiquetaNombre = findViewById(R.id.etiqueta_nombre)
        this.etiquetaApellido = findViewById(R.id.etiqueta_apellido)
        this.switchComenzar = findViewById(R.id.switch_comenzar)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_comenzar ->{

                if(etiquetaApellido.text.isEmpty() || etiquetaNombre.text.isEmpty()){
                    var notification = Snackbar.make(
                        p0,
                        "Todos los campos del nombre y apellido deben estar rellenos",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    notification.setAction("Aceptar"){}
                    notification.show()

                } else{
                    var accionPasar = Intent(applicationContext, SecondActivity::class.java)
                    var datosPasar: Bundle = Bundle()

                    datosPasar.putString("nombre", etiquetaNombre.text.toString())
                    datosPasar.putString("apellido",etiquetaApellido.text.toString())
                    accionPasar.putExtras(datosPasar)

                    startActivity(accionPasar)
                }
            }

            R.id.switch_comenzar ->{

            }
        }

    }
}