package com.example.calculadorarepaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculadorarepaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textNumero?.text = contador.toString()
        acciones()
    }

    private fun acciones() {
        binding.botonDecrementar.setOnClickListener(this)
        binding.botonIncrementar.setOnClickListener(this)
        binding.botonReset.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.boton_decrementar -> {
                contador--
            }

            R.id.boton_incrementar -> {
                contador++
            }

            R.id.boton_reset -> {
                contador = 0
            }
        }
        binding.textNumero?.text = contador.toString()
    }


}