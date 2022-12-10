package com.example.aplicacionhobbies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionhobbies.R
import com.example.aplicacionhobbies.model.Elemento

class AdaptadorHobbie(var context: Context, var lista: ArrayList<Elemento>) :
    RecyclerView.Adapter<AdaptadorHobbie.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        var holder = MyHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var hobbieFila = lista.get(position)
        holder.nombre.setText(hobbieFila.nombre)
        holder.detalle.setText(hobbieFila.detalle)
        holder.imagen.setImageResource(hobbieFila.imagen)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView
        var detalle: TextView
        var imagen: ImageView

        init {
            nombre = itemView.findViewById(R.id.nombre_fila)
            detalle = itemView.findViewById(R.id.detalle_fila)
            imagen = itemView.findViewById(R.id.imagen_fila)
        }
    }
}