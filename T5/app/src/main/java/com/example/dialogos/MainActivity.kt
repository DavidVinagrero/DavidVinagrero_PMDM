package com.example.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.dialogos.DialogoConfirmacion
import com.example.dialogos.dialogos.DialogoSeleccion
import com.example.dialogos.dialogos.DialogoSimple

class MainActivity : AppCompatActivity(), View.OnClickListener, DialogoConfirmacion.OnDialogoConfirmListener, DialogoSeleccion.OnDialogoSeleccionListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonListas.setOnClickListener(this)
        binding.botonSimple.setOnClickListener(this)
        binding.botonMultiple.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id -> {
                // objeto del diálogo --> la clase
                DialogoConfirmacion().show(supportFragmentManager, null)
            }

            binding.botonMultiple.id -> {
                DialogoSeleccion().show(supportFragmentManager, null)
            }

            binding.botonSimple.id -> {
                DialogoSimple().show(supportFragmentManager, null)
            }
        }
    }

    override fun onDialogoSelected(comunicacion: String) {
        binding.etiquetaConfirmacion.text = comunicacion
    }

    override fun onDialogoSeleccionSelected(comunicado: String) {
        binding.etiquetaMultiple.text = comunicado
    }
}