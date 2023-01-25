package com.example.t6_ejercicio_menurecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6_ejercicio_menurecycler.adapter.AdaptadorRecycler
import com.example.t6_ejercicio_menurecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorRecycler: AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorRecycler = AdaptadorRecycler(this,ArrayList())
        binding.recycler.adapter = adaptadorRecycler
        binding.recycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opcion_aniadir->{
                adaptadorRecycler.agregarDato("Prueba")
            }

            R.id.opcion_vaciar->{
                adaptadorRecycler.vaciarLista()
            }
        }

        return true
    }
}