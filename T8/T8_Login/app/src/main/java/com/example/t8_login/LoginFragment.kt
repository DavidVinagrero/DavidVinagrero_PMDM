package com.example.t8_login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t8_login.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        //auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonLogin.setOnClickListener {
            if(binding.editNombre.text.isNotEmpty() && binding.editPass.text.isNotEmpty()){

                val nombre = binding.editNombre.text.toString()
                val pass = binding.editPass.text.toString()
                auth.signInWithEmailAndPassword(nombre, pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val bundle = Bundle()
                        bundle.putString("nombre",nombre)
                        bundle.putString("uid",auth.currentUser!!.uid)
                        bundle.putInt("edad",-1)
                        findNavController().navigate(R.id.action_FirstFragment_to_secondActivity, bundle)
                    } else{
                        Snackbar.make(binding.botonLogin,"Datos incorrectos",Snackbar.LENGTH_LONG).show()
                    }
                }

            } else{
                Snackbar.make(binding.botonLogin,"Faltan datos",Snackbar.LENGTH_LONG).show()
            }
        }
        binding.botonRegistro.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}