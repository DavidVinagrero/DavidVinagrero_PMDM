package com.example.t3_listas_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.t3_listas_ret.adapter.AdaptadorUsuaro
import com.example.t3_listas_ret.databinding.ActivityMainBinding
import com.example.t3_listas_ret.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private lateinit var adaptadorBase: ArrayAdapter<CharSequence>
    //private lateinit var adaptadorBase: ArrayAdapter<Usuario>
    private lateinit var listaUsuarios: ArrayList<Usuario>
    private lateinit var adaptadorPersonalizado: AdaptadorUsuaro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun instancias() {
        //adaptadorBase = ArrayAdapter.createFromResource(applicationContext,R.array.usuarios,android.R.layout.simple_list_item_1)
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Luis", 123456,"masculino"))
        listaUsuarios.add(Usuario("Juan", 123456,"masculino"))
        listaUsuarios.add(Usuario("Celia", 123456,"female"))
        listaUsuarios.add(Usuario("Clemente", 123456,"female"))
        adaptadorPersonalizado = AdaptadorUsuaro(listaUsuarios, applicationContext)
        /*adaptadorBase =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listaUsuarios)*/
    }

    private fun asociarDatos() {
       // binding.listaUsuarios.adapter = adaptadorBase
        binding.listaUsuarios.adapter = adaptadorPersonalizado
    }

    private fun acciones() {
        binding.listaUsuarios.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.listaUsuarios, adaptadorPersonalizado.getItem(i)!!.toString(), Snackbar.LENGTH_SHORT)
                .show()
        }
    }
}
