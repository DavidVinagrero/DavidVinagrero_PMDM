package com.example.t8_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.t8_login.databinding.ActivitySecondBinding
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var dataBase: FirebaseDatabase
    // TODO Añadir el SDK de la Realtime Database, acceso a la base de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase = FirebaseDatabase.getInstance("https://pmdmret-dve2023-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val udi = intent.extras!!.getString("uid")
        val nombre = intent.extras!!.getString("nombre")
        val edad = intent.extras!!.getInt("edad")

        val referencia = dataBase.getReference("usuarios").child("")
        setContentView(binding.root)

        binding.botonAgregar.setOnClickListener {
            // agregar datos a la base de datos
            // dataBase.getReference("usuario").child("usuario1").setValue("Ejemplo")
            val referencina = dataBase.getReference("usuario").child("usuario2")
            referencina.child("dni").setValue("1234567W")
        }
    }
}