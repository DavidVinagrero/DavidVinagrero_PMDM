package com.example.ejercicio_empresa.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio_empresa.R
import com.example.ejercicio_empresa.dialog.DialogoEmpleado
import com.example.ejercicio_empresa.model.Empleado
import com.google.android.material.snackbar.Snackbar

class AdaptadorEmpleado(var listaDatos: ArrayList<Empleado>) :
    RecyclerView.Adapter<AdaptadorEmpleado.MyHolder>(){

    private var texto: String = ""

    class MyHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView = itemView.findViewById(R.id.item_nombre)
        var apellido: TextView = itemView.findViewById(R.id.item_apellido)
        var layout: LinearLayout = itemView.findViewById(R.id.layout_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val empleado = listaDatos[position]
        if (empleado.nombre != null) {
            holder.nombre.text = empleado.nombre
            holder.apellido.text = empleado.apellido
        }
        holder.layout.setOnClickListener {
            texto =
                "-Nombre: " + empleado.nombre + "\n-Apellido: " + empleado.apellido + "\n-Correo: " + empleado.correo + "\n-Puesto: " + empleado.puesto + "\n-Edad: " + empleado.edad
            //Snackbar.make(holder.nombre, "Este señor es: " + empleado.nombre, Snackbar.LENGTH_LONG).show()
            val dialogo = DialogoEmpleado.newInstance(texto)
        }
    }

    fun insertarEmpleado(empleado: Empleado) {
        listaDatos.add(empleado)
        notifyItemInserted(listaDatos.size - 1)
    }

}