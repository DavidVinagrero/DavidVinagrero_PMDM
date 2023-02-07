package com.example.t7_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.t7_fragments.databinding.ActivityMainBinding
import com.example.t7_fragments.fragment.FragmentBanner

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonUno.id->{
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()

                ft.replace(binding.sitioFragments.id,FragmentBanner())
                ft.commit()
            }
            binding.botonDos.id->{

            }
            binding.botonTres.id->{

            }
        }
    }
}