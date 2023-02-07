package com.example.t7_fragments.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t7_fragments.databinding.FragmentBannerBinding

class FragmentBanner: Fragment() {

    private lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater,container,false)
        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        binding.botonEstatico.setOnClickListener{
            lanzarDialogo().show()
        }
    }

    fun lanzarDialogo(): AlertDialog{
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("OJO !")
        builder.setMessage("Primera app de fragments realizada por David")
        return builder.create()
    }
}