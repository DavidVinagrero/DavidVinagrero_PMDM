package com.example.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.t6_menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var texto = ""

        when(item.itemId){
            R.id.menu_op_uno->{
                texto = "pulsado elemento 1"
            }
            R.id.menu_op_dos->{
                texto = "pulsado elemento 1"
            }
            R.id.menu_op_tres->{
                texto = "pulsado elemento 1"
            }
            R.id.menu_op_uno_uno->{
                texto = "pulsado elemento 1"
            }
            R.id.menu_op_uno_dos->{
                texto = "pulsado elemento 1"
            }
            R.id.menu_op_uno_tres->{
                texto = "pulsado elemento 1"
            }
        }
        Snackbar.make(binding.root,texto,Snackbar.LENGTH_SHORT).show()
        return true
    }
}