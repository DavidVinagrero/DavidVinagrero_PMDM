package com.example.repaso.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repaso.R
import com.example.repaso.model.Liga
import com.google.android.material.snackbar.Snackbar

class AdaptadorLigas(var context: Context) : RecyclerView.Adapter<AdaptadorLigas.MyHolder>() {

    private var listaLigas: ArrayList<Liga>

    init {
        listaLigas = ArrayList()
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoItem: TextView = itemView.findViewById(R.id.nombre_item)
        var textoItem2: TextView = itemView.findViewById(R.id.nombre_item2)
        var layout: LinearLayout = itemView.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View =
            LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaLigas.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val liga = listaLigas[position]
        holder.textoItem.text = liga.liga
        holder.textoItem2.text = liga.ligaAlternativa
        holder.layout.setOnClickListener {
            Snackbar.make(holder.layout, "Liga", Snackbar.LENGTH_LONG).show()
        }
    }

    fun agregarLiga(liga: Liga){
        this.listaLigas.add(liga)
        notifyItemInserted(listaLigas.size-1)
    }
}