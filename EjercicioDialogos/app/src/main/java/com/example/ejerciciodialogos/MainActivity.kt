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
import com.example.ejerciciodialogos.dialogos.DialogoFecha
import com.example.ejerciciodialogos.dialogos.DialogoHora

class MainActivity : AppCompatActivity(), View.OnClickListener,
    TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var botonCrear: Button

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
        Log.v("seleccionada_hora","Las "+p1+"h y $p2 minutos")
        DialogoFecha().show(supportFragmentManager, null)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            botonCrear.id -> {
                DialogoHora().show(supportFragmentManager, null)
                //DialogoFecha().show(supportFragmentManager, null)
            }
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Log.v("seleccionada_fecha","Día $p3, del mes "+(p2+1)+" del año $p1")
    }
}