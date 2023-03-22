package com.example.repaso

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repaso.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonLogin.setOnClickListener {
            if (binding.inputNombre.text.isNotEmpty() && binding.inputPass.text.isNotEmpty()){
                val nombre = binding.inputNombre.text.toString()
                val pass = binding.inputPass.text.toString()
                auth.signInWithEmailAndPassword(nombre,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val bundle = Bundle();
                        bundle.putString("nombre",nombre)
                        bundle.putString("uid",auth.currentUser!!.uid)
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
                    } else{
                        Snackbar.make(binding.botonLogin, "Contraseña o usuario incorrecto", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}