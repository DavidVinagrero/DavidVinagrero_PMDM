package com.example.t6_asignaturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.t6_asignaturas.databinding.ActivityMainBinding
import com.example.t6_asignaturas.dialogos.DialogoIntro
import com.example.t6_asignaturas.model.Asignatura

class MainActivity : AppCompatActivity(), DialogoIntro.OnRecyclerAsignaturasListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opcion_aniadir->{
                DialogoIntro().show(supportFragmentManager, null)
            }
            R.id.opcion_vaciar->{}
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun asignaturaSelecter(asignatura: Asignatura) {
        TODO("Not yet implemented")
    }
}
