package com.example.aplicacionhobbies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicacionhobbies.adapter.AdaptadorHobbie
import com.example.aplicacionhobbies.databinding.ActivityMainBinding
import com.example.aplicacionhobbies.model.Elemento
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),
    AdapterView.OnItemSelectedListener, AdaptadorHobbie.OnRecyclerElementoListener
{

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaHobbies: ArrayList<Elemento>
    private lateinit var adaptadorHobbie: AdaptadorHobbie
    private lateinit var listaSeries: ArrayList<Elemento>
    private lateinit var listaJuegos: ArrayList<Elemento>
    private lateinit var listaFutbol: ArrayList<Elemento>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        mostrarDatos()
        acciones()

    }

    private fun instancias() {
        ArrayAdapter.createFromResource(
            this,
            R.array.tipo_hobbies,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTipoHobbie.adapter = adapter
        }

        listaHobbies = ArrayList()

        listaFutbol = ArrayList()
        listaFutbol.add(Elemento(1,"Messi", "FC. Barcelona", R.drawable.messi))
        listaFutbol.add(Elemento(1,"Ronaldo", "Brasil", R.drawable.ronaldo))
        listaFutbol.add(Elemento(1,"Maradona", "Argentina", R.drawable.maradona))
        listaFutbol.add(Elemento(1,"Zidane", "Francia", R.drawable.zidane))

        listaSeries = ArrayList()
        listaSeries.add(Elemento(3,"Stranger Things", "Fantastica", R.drawable.stranger))
        listaSeries.add(Elemento(3,"Juego de tronos", "Histórica", R.drawable.tronos))
        listaSeries.add(Elemento(3,"Lost", "Fantastica", R.drawable.lost))
        listaSeries.add(Elemento(3,"La casa de papel", "Accion", R.drawable.papel))

        listaJuegos = ArrayList()
        listaJuegos.add(Elemento(2,"Metal Gear", "Sigilo", R.drawable.metal))
        listaJuegos.add(Elemento(2,"Gran Turismo", "Coches", R.drawable.gt))
        listaJuegos.add(Elemento(2,"God Of War", "Plataformas", R.drawable.god))
        listaJuegos.add(Elemento(2,"Final Fantasy X", "Rol", R.drawable.ffx))



        adaptadorHobbie = AdaptadorHobbie(this, listaHobbies)
    }

    private fun mostrarDatos() {
        binding.listaObjetos.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.listaObjetos.adapter = adaptadorHobbie
    }

    private fun acciones() {
        binding.spinnerTipoHobbie.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var creado:Int = 0
        when (p2) {
            // Fútbol
            0 -> {
                listaHobbies.removeAll(listaJuegos)
                listaHobbies.removeAll(listaSeries)
                listaHobbies.addAll(listaFutbol)
                binding.listaObjetos.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            }
            // Juegos
            1 -> {
                listaHobbies.removeAll(listaFutbol)
                listaHobbies.removeAll(listaSeries)
                listaHobbies.addAll(listaJuegos)
                binding.listaObjetos.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            }
            // Series
            2 -> {
                listaHobbies.removeAll(listaFutbol)
                listaHobbies.removeAll(listaJuegos)
                listaHobbies.addAll(listaSeries)
                binding.listaObjetos.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun comunicaElementoSelected(elemento: Elemento) {
        binding.imagenResultado.setImageResource(elemento.imagen)
        binding.nombreObjeto.setText(elemento.nombre)
        binding.detalleObjeto.setText(elemento.detalle)
    }

/*    fun comunicaElementoSelected(elemento: Elemento) {
        // Utilizar los datos
        Snackbar.make(binding.listaObjetos,
            "Elemento ${elemento.nombre}", Snackbar.LENGTH_SHORT).show()
    }*/
}

