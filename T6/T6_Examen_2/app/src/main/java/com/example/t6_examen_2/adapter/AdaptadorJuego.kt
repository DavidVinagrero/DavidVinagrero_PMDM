package com.example.t6_examen_2.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.t6_examen_2.DetallesActivity
import com.example.t6_examen_2.R
import com.example.t6_examen_2.dialog.DialogoFiltro
import com.example.t6_examen_2.model.Juego
import com.google.android.material.snackbar.Snackbar

class AdaptadorJuego(var listaDatos: ArrayList<Juego>, var context: Context) :
    RecyclerView.Adapter<AdaptadorJuego.MyHolder>() {

    var onJuegoClick: ((juego: Juego)-> Unit)? = null
    var onFavoritoClick: ((juego: Juego)->Unit)? = null
    lateinit var listaFavoritos: ArrayList<Juego>
    var listaAux = ArrayList<Juego>()


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView
        var toolbarNombre: androidx.appcompat.widget.Toolbar
        init {
            textoNombre = itemView.findViewById(R.id.texto_nombre)
            toolbarNombre = itemView.findViewById(R.id.recycler_toolbar)
        }

    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val juego = listaDatos[position]

        holder.textoNombre.setText(juego.descripcion)
        holder.toolbarNombre.setTitle(juego.nombre)

        holder.toolbarNombre.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_item_favorito -> {
                    onFavoritoClick?.invoke(juego)
                }
                R.id.menu_item_ver_detalle -> {
                    //Log.v("resultados",listaDatos.get(position).nombre)
                    onJuegoClick?.invoke(juego)
                    //Snackbar.make(holder.itemView,"${juego.nombre}", Snackbar.LENGTH_SHORT).show()
                }
            }

            return@setOnMenuItemClickListener true
        }
    }

    fun mostrarListaFav(list: ArrayList<Juego>){
        listaAux = listaDatos
        listaDatos.clear()
        notifyDataSetChanged()
        for (j in list){
            listaDatos.add(j)
        }
        notifyDataSetChanged()
    }

    fun borrarFiltros(){
        listaDatos.clear()
        listaDatos.add(Juego("Elden Ring", "rol", R.drawable.elden, "xbox", 4.99))
        listaDatos.add(Juego("Gran turismo", "coches", R.drawable.gt7, "ps5", 23.99))
        listaDatos.add(Juego("Persona 5 Royal", "plataformas", R.drawable.personal,"switch",12.95))
        listaDatos.add(Juego("Red Dead Redemption", "mundo abierto", R.drawable.red, "ps5", 49.97))
        listaDatos.add(Juego("Fifa 23", "fútbol", R.drawable.fifa, "xbox", 50.65))
        listaDatos.add(Juego("Half - life", "shooter", R.drawable.half, "pc", 0.65))
        listaDatos.add(Juego("The Legend of Zelda", "plataformas", R.drawable.zelda, "switch", 59.95))
        listaDatos.add(Juego("Super Mario, switch", "plataformas", R.drawable.mario, "switch", 49.50))
        listaDatos.add(Juego("Super Smash Bros, switch", "peleas", R.drawable.smash, "switch", 69.98))
        listaDatos.add(Juego("The Last of Us", "aventuras", R.drawable.last, "ps5", 45.60))
        listaDatos.add(Juego("Resident Evil 7", "terror", R.drawable.resident, "ps5", 23.67))
        listaDatos.add(Juego("GTA V", "mundo abierto", R.drawable.gta, "xbox", 15.96))
        listaDatos.add(Juego("God of War", "plataformas", R.drawable.god, "ps4", 9.99))
        listaDatos.add(Juego("Forza Horizon 4", "coches", R.drawable.forza, "xbox", 23.0))
        listaDatos.add(Juego("BioShock", "futurista", R.drawable.bioshock, "pc", 0.0))
        notifyDataSetChanged()
    }

    fun agregarDato(juego: Juego) {
        listaDatos.add(juego)
        notifyItemInserted(listaDatos.size - 1)
    }

    interface OnJuegoListener {
        fun onJuegoClick(juego: Juego)
    }
}
