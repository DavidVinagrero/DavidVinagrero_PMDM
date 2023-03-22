package com.example.ejerciciodialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.ejerciciodialogos.dialogos.*


class MainActivity : AppCompatActivity(), View.OnClickListener,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener,
    DialogoInicio.OnInicioListener, DialogoComunica.OnComunicaListener,
    DialogoAsignaturas.OnAsignaturasSelected, DialogoNota.OnNotaSelected, DialogoFinal.OnDialogoFinalListener {

    private lateinit var botonCrear: Button

    private var horaSeleccionada: String = ""
    private var fechaSeleccionada: String = ""
    private var nombreApellidos: String = ""
    private var asignaturasSeleccionadas: String = ""
    private var notaMedia: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instancias()
        acciones()
    }

    private fun instancias() {
        botonCrear = this.findViewById(R.id.boton_crear)
    }

    private fun acciones() {
        botonCrear.setOnClickListener(this)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Log.v("seleccionada_hora", "Las " + p1 + "h y $p2 minutos")
        horaSeleccionada = "${p1}:${p2}"
        DialogoFecha().show(supportFragmentManager, null)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            botonCrear.id -> {
                DialogoHora().show(supportFragmentManager, null)
                //DialogoFecha().show(supportFragmentManager, null)
            }
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Log.v("seleccionada_fecha", "Día $p3, del mes " + (p2 + 1) + " del año $p1")
        fechaSeleccionada = "${p3}/${p2 + 1}/${p1}"
        DialogoInicio().show(supportFragmentManager, null)
    }

    override fun onInicioListenerSelected(nombre: String, apellido: String) {
        nombreApellidos = "$nombre $apellido"
        val dialogo =
            DialogoComunica.newInstance(nombreApellidos, horaSeleccionada, fechaSeleccionada)
        dialogo.show(supportFragmentManager, null)
    }

    override fun onDialogoComunicaListener() {
        DialogoAsignaturas().show(supportFragmentManager, null)
    }

    override fun onDialogoAsignaturasSelected(asignaturas: String) {
        asignaturasSeleccionadas = asignaturas
        DialogoNota().show(supportFragmentManager, null)
    }

    override fun onNotaDialogoSelected(nota: Int) {
        notaMedia = nota
        Log.v("Nota_input","Ha pasado")
        val dialogo2 =
            DialogoFinal.newInstance(nombreApellidos,fechaSeleccionada,horaSeleccionada,asignaturasSeleccionadas,notaMedia)
        DialogoFinal().show(supportFragmentManager, null)
    }

    override fun onDialogSelected() {

    }
}