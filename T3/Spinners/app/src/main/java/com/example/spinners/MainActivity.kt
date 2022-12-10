package com.example.spinners

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.spinners.adapter.AdapterPais
import com.example.spinners.databinding.ActivityMainBinding
import com.example.spinners.model.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSimple: ArrayAdapter<Pais>
    private lateinit var arrayDatos: ArrayList<Pais>
    private lateinit var adaptadorPais: AdapterPais
    private var nombre: String = ""
    private var estrella: String = ""
    var seleccionado:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // parte gráfica binding.spinnerSimple
        // parte lógica --> lista de datos (Array - ArrayList ó un recurso),
        //                  vista gráfica --> android.R.layout.simple_spinner_item
        //                  contexto --> getApplicactionContext
        instancias()
        asociarDatos()
        rellenarLista()
        acciones()
    }

    private fun instancias() {
        arrayDatos = ArrayList()
        adaptadorPais = AdapterPais(arrayDatos,applicationContext)
        adaptadorSimple =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arrayDatos)
        adaptadorSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        /* adaptadorSimple = ArrayAdapter.createFromResource(
             applicationContext,
             R.array.array_recurso,
             android.R.layout.simple_spinner_item
         )*/
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSimple
        binding.spinnerComplejo.adapter = adaptadorPais
    }

    private fun rellenarLista() {
        /*arrayDatos.add("Elemento uno")
        arrayDatos.add("Elemento dos")
        arrayDatos.add("Elemento tres")
        arrayDatos.add("Elemento cuatro")*/
        arrayDatos.add(Pais("España", R.drawable.espania, 1, "Pedri"))
        arrayDatos.add(Pais("Brasil", R.drawable.brasil, 5, "Neymar"))
        arrayDatos.add(Pais("Alemania", R.drawable.alemania, 5, "Muller"))
        arrayDatos.add(Pais("Argetina", R.drawable.argentina, 2, "Messi"))
        arrayDatos.add(Pais("Francia", R.drawable.francia, 2, "Mbappe"))
        arrayDatos.add(Pais("Qtar", R.drawable.qatar, 0, "Desconocido"))
        adaptadorSimple.notifyDataSetChanged()
        adaptadorPais.notifyDataSetChanged()
        println()
    }


    private fun acciones() {
        binding.spinnerSimple.onItemSelectedListener = this
        binding.spinnerComplejo.onItemSelectedListener = this

            binding.botonDetalle.setOnClickListener {
                var accionPasar = Intent(applicationContext, DetailActivity::class.java)
                var datosPasar: Bundle = Bundle()

                datosPasar.putString("nombre",nombre)
                datosPasar.putString("estrella",estrella)
                accionPasar.putExtras(datosPasar)

                Log.v("datos_pasar","Nombre: "+nombre)
                Log.v("datos_pasar","Estrella: "+estrella)

                startActivity(accionPasar)
            }


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // p0 --> vista del evento
        // p1 --> la fila que se ha pulsado
        // p2 --> la posicion pulsada 0..n
        // p3 --> id (pk): id --> posición
        /*Snackbar.make(
            binding.spinnerSimple,
            adaptadorSimple.getItem(p2)!!.getEstrella() ?: "No hay datos",
            Snackbar.LENGTH_SHORT
        ).show()*/
        nombre = adaptadorSimple.getItem(p2)?.getNombre() ?: "No hay datos"
        estrella = adaptadorSimple.getItem(p2)?.getEstrella() ?: "No hay datos"
        seleccionado = true
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}