package com.example.examendve_evaluacion

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examendve_evaluacion.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var listener: onFirstFragmentListener

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = Firebase.database("https://pmdmret-dve2023-default-rtdb.firebaseio.com/")
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
            var nombre = binding.inputNombre.text.toString()
            var pass = binding.inputPass.text.toString()
            var contador: Int = 0
            auth.signInWithEmailAndPassword(nombre, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val usuario = database.getReference("usuarios").child(auth.currentUser?.uid.toString()).child("logoncount").addListenerForSingleValueEvent(object: ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            contador = snapshot.value.toString().toInt()
                            contador++
                            database.getReference("usuarios").child(auth.currentUser?.uid.toString()).child("logoncount").setValue(contador)
                        }

                        override fun onCancelled(error: DatabaseError) {
                        }

                    })
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

                } else {
                    Snackbar.make(
                        binding.botonLogin,
                        "Usuario o contraseña erróneo",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface onFirstFragmentListener{
        fun onFirstFragmentSelected(uid: String)
    }
}