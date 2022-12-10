package com.example.t3_listas_holder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t3_listas_holder.adapter.AdaptadorRecycler
import com.example.t3_listas_holder.databinding.ActivityMainBinding
import com.example.t3_listas_holder.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>
    private lateinit var adaptadorRecycler: AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun instancias() {
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Ejemplo", "Trabajo", "distant@ejemplo", 52))

        // crear adaptador
        adaptadorRecycler = AdaptadorRecycler(this, listaUsuarios)

        // mostrar recycler view
        binding.listaRecycler.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.listaRecycler.adapter = adaptadorRecycler
    }
    private fun acciones() {
        binding.botonAniadir.setOnClickListener {
            if (binding.nombreInput.text.isNotEmpty() || binding.apellidoInput.text.isNotEmpty() ||
                binding.correoInput.text.isNotEmpty() || binding.edadInput.text.isNotEmpty()) {
                listaUsuarios.add(
                    Usuario(
                        binding.nombreInput.text.toString(),
                        binding.apellidoInput.text.toString(),
                        binding.correoInput.text.toString(),
                        binding.edadInput.text.toString().toInt()
                    )
                )
                adaptadorRecycler.notifyItemInserted(listaUsuarios.size-1)
            }
        }
    }
}
