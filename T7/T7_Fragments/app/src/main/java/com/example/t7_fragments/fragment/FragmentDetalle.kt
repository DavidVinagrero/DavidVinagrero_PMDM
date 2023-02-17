package com.example.t7_fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t7_fragments.databinding.FragmentDetalleBinding
import com.example.t7_fragments.databinding.FragmentNombreBinding

class FragmentDetalle: Fragment() {

    private lateinit var binding: FragmentDetalleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

}