package com.example.examendve_evaluacion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examendve_evaluacion.R
import com.example.examendve_evaluacion.model.Producto
import com.google.android.material.snackbar.Snackbar

class AdaptadorProductos(var lista: ArrayList<Producto>):
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    class MyHolder( var itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagenItem: ImageView = itemView.findViewById(R.id.imagen_item)
        var textoItem: TextView = itemView.findViewById(R.id.texto_item)
        var layout: LinearLayout = itemView.findViewById(R.id.layout_inicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]
        holder.textoItem.text = producto.title
        Glide.with(holder.textoItem).load(producto.thumbnail).into(holder.imagenItem)
        holder.layout.setOnClickListener {
            Snackbar.make(
                holder.textoItem,
                "Este producto cuesta: "+producto.price,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    fun insertarProducto(producto: Producto){
        lista.add(producto)
        notifyItemInserted(lista.size-1)
    }
}