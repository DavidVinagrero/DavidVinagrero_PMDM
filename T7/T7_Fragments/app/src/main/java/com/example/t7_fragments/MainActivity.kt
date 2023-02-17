package com.example.t7_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.t7_fragments.databinding.ActivityMainBinding
import com.example.t7_fragments.fragment.FragmentBanner
import com.example.t7_fragments.fragment.FragmentDetalle
import com.example.t7_fragments.fragment.FragmentNombre

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

                ft.replace(binding.sitioFragments.id, FragmentNombre())
                ft.addToBackStack(null)
                ft.commit()

                /*ft.replace(binding.sitioFragments.id,FragmentBanner())
                ft.commit()*/
            }
            binding.botonDos.id->{
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()

                ft.replace(binding.sitioFragments.id, FragmentDetalle())
                ft.addToBackStack(null)
                ft.commit()

            }
            binding.botonTres.id->{

            }
        }
    }
}