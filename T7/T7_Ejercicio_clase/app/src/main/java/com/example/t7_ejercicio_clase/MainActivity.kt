package com.example.t7_ejercicio_clase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t7_ejercicio_clase.databinding.ActivityMainBinding
import com.example.t7_ejercicio_clase.fragment.FragmentHome
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var usuarios: ArrayList<String> = ArrayList()
    private var contrasenias: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rellenarListas()
        acciones()
    }

    private fun rellenarListas() {
        usuarios.add("admin")
        usuarios.add("user")
        usuarios.add("guest")

        contrasenias.add("admin")
        contrasenias.add("user")
        contrasenias.add("guest")
    }

    private fun acciones() {
        binding.botonAcceder.setOnClickListener {
            if (!binding.inputContrasenia.text.isEmpty() || !binding.inputNombre.text.isEmpty()) {
                if(validarUsuarioContrasenia(binding.inputContrasenia.text.toString(), binding.inputNombre.text.toString())){
                    val fm = supportFragmentManager
                    val ft = fm.beginTransaction()
                    ft.replace(binding.ubicacionFragments.id, FragmentHome())
                    ft.commit()

                    Snackbar.make(
                        findViewById(R.id.boton_acceder),
                        "Usuario CORRECTO",
                        Snackbar.LENGTH_LONG
                    ).show()
                }else{
                    Snackbar.make(
                        findViewById(R.id.boton_acceder),
                        "Datos erróneos",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun validarUsuarioContrasenia(pass: String, usuario: String): Boolean {
        for ((con, item) in usuarios.withIndex()){

            if(usuario == usuarios[con] && pass == contrasenias[con]){
                Log.v("Bucle","usuario: "+usuario+" == "+usuarios[con])
                return true
            }
        }

        return false
    }

}