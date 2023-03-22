package com.example.examendve_evaluacion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examendve_evaluacion.adapter.AdaptadorProductos
import com.example.examendve_evaluacion.databinding.FragmentSecondBinding
import com.example.examendve_evaluacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var database: FirebaseDatabase
    private lateinit var adaptadorProductos: AdaptadorProductos


    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
            }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = Firebase.database("https://pmdmret-dve2023-default-rtdb.firebaseio.com/")
        adaptadorProductos = AdaptadorProductos(ArrayList<Producto>(),)
        binding.recycler.adapter = adaptadorProductos
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val database =
            Firebase.database("https://pmdmret-dve2023-default-rtdb.firebaseio.com/")
        database.getReference("productos").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (i in snapshot.children){
                        adaptadorProductos.insertarProducto(i.getValue(Producto::class.java) as Producto)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}