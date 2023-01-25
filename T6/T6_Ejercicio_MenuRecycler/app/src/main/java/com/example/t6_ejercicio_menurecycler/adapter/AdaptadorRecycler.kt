package com.example.t6_ejercicio_menurecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t6_ejercicio_menurecycler.R
import com.example.t6_ejercicio_menurecycler.model.Alerta

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<String>): RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    inner class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {
        lateinit var textoNombre: TextView

        init {
            textoNombre = view.findViewById(R.id.texto_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val nombre = listaDatos[position]
        holder.textoNombre.text = nombre
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    fun agregarDato(nombre: String){
        listaDatos.add(nombre)
        notifyItemInserted(listaDatos.size-1)
    }

    fun vaciarLista(){
        listaDatos.clear()
        notifyDataSetChanged()
    }

}