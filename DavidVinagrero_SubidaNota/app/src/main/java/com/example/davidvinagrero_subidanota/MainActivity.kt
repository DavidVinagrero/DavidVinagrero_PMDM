package com.example.davidvinagrero_subidanota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.davidvinagrero_subidanota.databinding.ActivityMainBinding
import com.example.davidvinagrero_subidanota.dialogo.DialogoPersonalizado

class MainActivity : View.OnClickListener , AppCompatActivity(), DialogoPersonalizado.OnDialogoPersonalizadoListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonConvertir.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConvertir.id -> {
                DialogoPersonalizado().show(supportFragmentManager, null)
            }
        }
    }

    override fun onDialogoPersonalizadoSet(moneda1: String, moneda2: String, cantidad: Int) {
        Log.v("DatosPasados", "Cambio de "+moneda1+" a "+moneda2)
    }
}