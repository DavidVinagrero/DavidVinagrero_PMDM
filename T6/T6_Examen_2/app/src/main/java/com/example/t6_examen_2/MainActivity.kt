package com.example.t6_examen_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6_examen_2.adapter.AdaptadorJuego
import com.example.t6_examen_2.databinding.ActivityMainBinding
import com.example.t6_examen_2.dialog.DialogoFiltro
import com.example.t6_examen_2.model.Juego
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoFiltro.OnRecyclerJuegosListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorJuego: AdaptadorJuego
    private lateinit var listaFavoritos: ArrayList<Juego>

    private var nombre: String = ""
    private var descripcion: String = ""
    private var plataforma: String = ""
    private var imagen: Int = 0
    private var precio: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarRecycler()
        datosActivity()
    }

    private fun datosActivity() {
        adaptadorJuego.onJuegoClick = {
            nombre = it.nombre
            descripcion = it.descripcion
            plataforma = it.plataforma
            imagen = it.imagen
            precio = it.preio

            var accionPasar = Intent(this, DetallesActivity::class.java)
            var datosPasar: Bundle = Bundle()
            datosPasar.putString("nombre", nombre)
            datosPasar.putString("descripcion", descripcion)
            datosPasar.putInt("imagen", imagen)
            datosPasar.putDouble("precio", precio)
            accionPasar.putExtras(datosPasar)

            startActivity(accionPasar)
        }
        listaFavoritos = ArrayList()

        adaptadorJuego.onFavoritoClick = {
            listaFavoritos.add(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun configurarRecycler() {
        adaptadorJuego = AdaptadorJuego(ArrayList(), this)
        binding.recycler.adapter = adaptadorJuego
        binding.recycler.layoutManager = GridLayoutManager(applicationContext,2, GridLayoutManager.VERTICAL, false)


        adaptadorJuego.agregarDato(Juego("Elden Ring", "rol", R.drawable.elden, "xbox", 4.99))
        adaptadorJuego.agregarDato(Juego("Gran turismo", "coches", R.drawable.gt7, "ps5", 23.99))
        adaptadorJuego.agregarDato(
            Juego(
                "Persona 5 Royal",
                "plataformas",
                R.drawable.personal,
                "switch",
                12.95
            )
        )
        adaptadorJuego.agregarDato(
            Juego(
                "Red Dead Redemption",
                "mundo abierto",
                R.drawable.red,
                "ps5",
                49.97
            )
        )
        adaptadorJuego.agregarDato(Juego("Fifa 23", "fútbol", R.drawable.fifa, "xbox", 50.65))
        adaptadorJuego.agregarDato(Juego("Half - life", "shooter", R.drawable.half, "pc", 0.65))
        adaptadorJuego.agregarDato(
            Juego(
                "The Legend of Zelda",
                "plataformas",
                R.drawable.zelda,
                "switch",
                59.95
            )
        )
        adaptadorJuego.agregarDato(
            Juego(
                "Super Mario, switch",
                "plataformas",
                R.drawable.mario,
                "switch",
                49.50
            )
        )
        adaptadorJuego.agregarDato(
            Juego(
                "Super Smash Bros, switch",
                "peleas",
                R.drawable.smash,
                "switch",
                69.98
            )
        )
        adaptadorJuego.agregarDato(
            Juego(
                "The Last of Us",
                "aventuras",
                R.drawable.last,
                "ps5",
                45.60
            )
        )
        adaptadorJuego.agregarDato(
            Juego(
                "Resident Evil 7",
                "terror",
                R.drawable.resident,
                "ps5",
                23.67
            )
        )
        adaptadorJuego.agregarDato(Juego("GTA V", "mundo abierto", R.drawable.gta, "xbox", 15.96))
        adaptadorJuego.agregarDato(Juego("God of War", "plataformas", R.drawable.god, "ps4", 9.99))
        adaptadorJuego.agregarDato(
            Juego(
                "Forza Horizon 4",
                "coches",
                R.drawable.forza,
                "xbox",
                23.0
            )
        )
        adaptadorJuego.agregarDato(Juego("BioShock", "futurista", R.drawable.bioshock, "pc", 0.0))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_filtrar -> {
                DialogoFiltro().show(supportFragmentManager, "")
            }
            R.id.menu_favoritos -> {
                adaptadorJuego.mostrarListaFav(listaFavoritos)
                //Log.v("resultados", "${nombre}, ${descripcion},${plataforma},${imagen},${precio}")

            }
            R.id.menu_borrar -> {
                adaptadorJuego.borrarFiltros()
            }
        }
        return true
    }

    override fun juegoSelected(juego: Juego) {
        TODO("Not yet implemented")
    }
}