package com.example.examen_t6_davidvinagreroencina

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_t6_davidvinagreroencina.adapter.AdaptadorRecycler
import com.example.examen_t6_davidvinagreroencina.databinding.ActivityMainBinding
import com.example.examen_t6_davidvinagreroencina.dialogo.DialogoDetalle
import com.example.examen_t6_davidvinagreroencina.dialogo.DialogoDetalle.Companion
import com.example.examen_t6_davidvinagreroencina.dialogo.DialogoFecha
import com.example.examen_t6_davidvinagreroencina.dialogo.DialogoHora
import com.example.examen_t6_davidvinagreroencina.model.Viaje
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener, AdaptadorRecycler.OnRecyclerListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaViajes: ArrayList<Viaje>
    private lateinit var adaptadorViaje: AdaptadorRecycler

    private var dia: Int = 0
    private var mes: Int = 0
    private var anio: Int = 0
    private var hora: Int = 0
    private var minuto: Int = 0

    private var diaF: Int = 0
    private var mesF: Int = 0
    private var anioF: Int = 0
    private var horaF: Int = 0
    private var minutoF: Int = 0
    private var pulsado: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rellenarSpinners()
        acciones()
    }

    private fun rellenarSpinners() {
        listaViajes = ArrayList()

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.ciudades,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ciudadOrigen.adapter = adapter
        binding.ciudadDestino.adapter = adapter
    }

    private fun acciones() {
        binding.horaSalida.setOnClickListener {
            pulsado = true
            DialogoFecha().show(supportFragmentManager, "")
        }
        binding.horaLlegada.setOnClickListener {
            DialogoFecha().show(supportFragmentManager, "")
        }

        binding.botonAceptar.setOnClickListener{
            if (!binding.ciudadDestino.equals(binding.ciudadOrigen) || !binding.horaLlegada.text.isEmpty() || !binding.horaSalida.text.isEmpty()) {
                var viaje = Viaje(
                    binding.ciudadOrigen.selectedItem.toString(),
                    binding.ciudadDestino.selectedItem.toString(),
                    "${dia}/${mes}/${anio}",
                    "${diaF}/${mesF}/${anioF}",
                    "${hora}:${minuto}",
                    "${horaF}:${minutoF}")

                listaViajes.add(viaje)
                adaptadorViaje = AdaptadorRecycler(this, listaViajes)

                binding.recyclerCiudades.adapter = adaptadorViaje
                binding.recyclerCiudades.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

                Snackbar.make(binding.root, "Viaje añadido",Snackbar.LENGTH_SHORT ).show()
                binding.horaSalida.text = "Día salida"
                binding.horaLlegada.text = "Día llegada"
            } else{
                Snackbar.make(binding.root, "Uno de los datos no es correcto",Snackbar.LENGTH_SHORT ).show()
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //Snackbar.make(binding.root, " ${year} ${month} ${dayOfMonth}",Snackbar.LENGTH_SHORT ).show()
        if (pulsado) {
            dia = dayOfMonth
            mes = month
            anio = year
        } else {
            diaF = dayOfMonth
            mesF = month
            anioF = year
        }
        DialogoHora().show(supportFragmentManager, "")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        //Snackbar.make(binding.root, " ${hourOfDay} ${minute}",Snackbar.LENGTH_SHORT ).show()
        if (pulsado) {
            hora = hourOfDay
            minuto = minute
            binding.horaSalida.text = "${dia}/${mes+1}/${anio} a las ${hourOfDay}:${minute}"
            pulsado = false
        } else if (!pulsado) {
            horaF = hourOfDay
            minutoF = minute
            binding.horaLlegada.text = "${diaF}/${mesF+1}/${anioF} a las ${hourOfDay}:${minute}"
        }
    }
}