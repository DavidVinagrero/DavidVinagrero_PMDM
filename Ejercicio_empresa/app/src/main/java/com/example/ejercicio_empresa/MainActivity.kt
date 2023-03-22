package com.example.ejercicio_empresa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio_empresa.adapter.AdaptadorEmpleado
import com.example.ejercicio_empresa.databinding.ActivityMainBinding
import com.example.ejercicio_empresa.model.Empleado

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorEmpleado: AdaptadorEmpleado
    private lateinit var listaEmpleados: ArrayList<Empleado>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rellenarSpinner()
        acciones()
    }

    private fun rellenarSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.trabajos,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTrabajo.setAdapter(adapter)

        adaptadorEmpleado = AdaptadorEmpleado(ArrayList<Empleado>())
        binding.recycler.adapter = adaptadorEmpleado
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun acciones() {
        binding.botonCrear.setOnClickListener {
            if (binding.inputNombre.text.isNotEmpty() && binding.inputApellido.text.isNotEmpty()
                && binding.inputCorreo.text.isNotEmpty() && binding.inputEdad.text.isNotEmpty()
            ) {
                var empleado: Empleado = Empleado(
                    binding.inputNombre.text.toString(),
                    binding.inputApellido.text.toString(),
                    binding.inputCorreo.text.toString(),
                    binding.inputEdad.text.toString().toInt(),
                    "puesto"
                )
                adaptadorEmpleado.insertarEmpleado(empleado)
            }
        }
    }
}