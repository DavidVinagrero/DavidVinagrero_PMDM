package com.example.examendavidvinagreroe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    lateinit var botonCalcular: Button
    lateinit var etiquetaNotaUno: EditText
    lateinit var etiquetaNotaDos: EditText
    lateinit var nombreRecuperado: String
    lateinit var apellidoRecuperado: String

    lateinit var grupoRadiosAsignaturas: RadioGroup
    lateinit var radioUnoAsignatura: RadioButton
    lateinit var radioDosAsignatura: RadioButton
    lateinit var radioTresAsignatura: RadioButton
    lateinit var radioCuatroAsignatura: RadioButton
    lateinit var radioCincoAsignatura: RadioButton

    lateinit var grupoRadiosProfesores: RadioGroup
    lateinit var radioUnoProfesor: RadioButton
    lateinit var radioDosProfesor: RadioButton
    lateinit var radioTresProfesor: RadioButton
    lateinit var radioCuatroProfesor: RadioButton

    var seleccionadoAsignatura: Boolean = false
    var seleccionadoProfesor: Boolean = false
    var profesorFavorito: String = ""
    var asignaturaFavorita: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        recuperarDatos()
        acciones()
    }

    private fun acciones() {
        grupoRadiosAsignaturas.setOnCheckedChangeListener { grupoRadios, i ->
            var radioSeleccionado: RadioButton = findViewById(i)
            when (radioSeleccionado.text.toString()) {
                "PMDM" -> {
                    etiquetaNotaUno.setHint("Introduce tu 1ª nota de PMDM")
                    etiquetaNotaDos.setHint("Introduce tu 2ª nota de PMDM")
                    seleccionadoAsignatura = true
                    asignaturaFavorita = "PMDM"

                }
                "DI" -> {
                    etiquetaNotaUno.setHint("Introduce tu 1ª nota de DI")
                    etiquetaNotaDos.setHint("Introduce tu 2ª nota de DI")
                    seleccionadoAsignatura = true
                    asignaturaFavorita = "DI"
                }
                "AD" -> {
                    etiquetaNotaUno.setHint("Introduce tu 1ª nota de AD")
                    etiquetaNotaDos.setHint("Introduce tu 2ª nota de AD")
                    seleccionadoAsignatura = true
                    asignaturaFavorita = "AD"
                }
                "SGE" -> {
                    etiquetaNotaUno.setHint("Introduce tu 1ª nota de SGE")
                    etiquetaNotaDos.setHint("Introduce tu 2ª nota de SGE")
                    seleccionadoAsignatura = true
                    asignaturaFavorita = "SGE"
                }
                "PSP" -> {
                    etiquetaNotaUno.setHint("Introduce tu 1ª nota de PSP")
                    etiquetaNotaDos.setHint("Introduce tu 2ª nota de PSP")
                    seleccionadoAsignatura = true
                    asignaturaFavorita = "PSP"
                }

            }
        }

        grupoRadiosProfesores.setOnCheckedChangeListener { grupoRadios, i ->
            var radioSeleccionado: RadioButton = findViewById(i)
            when (radioSeleccionado.text.toString()) {
                "D. Manuel" -> {
                    seleccionadoProfesor = true
                    profesorFavorito = "D. Manuel"
                }
                "D. Carlos" -> {
                    seleccionadoProfesor = true
                    profesorFavorito = "D. Carlos"
                }
                "D. Agustín" -> {
                    seleccionadoProfesor = true
                    profesorFavorito = "D. Agustin"
                }
                "D. Alverto" -> {
                    seleccionadoProfesor = true
                    profesorFavorito = "D. Alverto"
                }
            }
        }

        botonCalcular.setOnClickListener {
            if (etiquetaNotaUno.text.isEmpty() || etiquetaNotaDos.text.isEmpty() || !seleccionadoProfesor || !seleccionadoAsignatura) {
                var notification = Snackbar.make(
                    it,
                    "Todos los campos de notas deben estar rellenos, un profesor elegido y una asignatura",
                    Snackbar.LENGTH_INDEFINITE
                )
                notification.setAction("Aceptar") {}
                notification.show()
            } else {
                var accionPasar = Intent(applicationContext, ThirdActivity::class.java)
                var datosPasar: Bundle = Bundle()

                datosPasar.putDouble("nota1", etiquetaNotaUno.text.toString().toDouble())
                datosPasar.putDouble("nota2",etiquetaNotaDos.text.toString().toDouble())
                datosPasar.putString("nombre", nombreRecuperado)
                datosPasar.putString("apellido", apellidoRecuperado)
                datosPasar.putString("asignatura", asignaturaFavorita)
                datosPasar.putString("profesor", profesorFavorito)
                accionPasar.putExtras(datosPasar)

                startActivity(accionPasar)
            }
        }
    }

    private fun recuperarDatos() {
        nombreRecuperado = intent.extras?.getString("nombre", "defecto") ?: "defecto"
        apellidoRecuperado = intent.extras?.getString("apellido", "defecto") ?: "defecto"
    }

    private fun instancias() {
        this.botonCalcular = findViewById(R.id.boton_calcular)
        this.etiquetaNotaUno = findViewById(R.id.etiqueta_nota1)
        this.etiquetaNotaDos = findViewById(R.id.etiqueta_nota2)
        this.grupoRadiosAsignaturas = findViewById(R.id.grupo_radios_asignaturas)
        this.radioUnoAsignatura = findViewById(R.id.radio_1_asignaturas)
        this.radioDosAsignatura = findViewById(R.id.radio_2_asignaturas)
        this.radioTresAsignatura = findViewById(R.id.radio_3_asignaturas)
        this.radioCuatroAsignatura = findViewById(R.id.radio_4_asignaturas)
        this.radioCincoAsignatura = findViewById(R.id.radio_5_asignaturas)
        this.grupoRadiosProfesores = findViewById(R.id.grupo_radios_profesores)
        this.radioUnoProfesor = findViewById(R.id.opcion_1_profesores)
        this.radioDosProfesor = findViewById(R.id.opcion_2_profesores)
        this.radioTresProfesor = findViewById(R.id.opcion_3_profesores)
        this.radioCuatroProfesor = findViewById(R.id.opcion_4_profesores)
    }


}