package com.example.repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repaso.adapter.AdaptadorLigas
import com.example.repaso.databinding.ActivityMainBinding
import com.example.repaso.databinding.ActivitySecondBinding
import com.example.repaso.model.Liga
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var adaptadorLigas: AdaptadorLigas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)

        database =
            FirebaseDatabase.getInstance("https://pmdmret-ligas-dve-default-rtdb.firebaseio.com/")
        adaptadorLigas = AdaptadorLigas(applicationContext)

        binding.recycler.adapter = adaptadorLigas
        binding.recycler.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        val uid = intent.extras!!.getString("uid")
        val nombre = intent.extras!!.getString("nombre")
        val referencia = database.getReference("pmdm")
        setContentView(binding.root)



        binding.botonActualizar.setOnClickListener {
            Log.v("Cosa_extraña", "Se ha pulsado")
            referencia.child("ligas").child("leages").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (item in snapshot.children){
                        val ligas = item.getValue(Liga::class.java)
                        Log.v("Cosa_extraña", "Esto es el objeto: $ligas ?")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}