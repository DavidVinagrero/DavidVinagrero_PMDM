package com.example.t3_listas_holder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t3_listas_holder.R
import com.example.t3_listas_holder.model.Usuario

class AdaptadorRecycler(var context: Context, var lista: ArrayList<Usuario>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        var holder = MyHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        // personaliza cada una de las filas -> holder
        var usuarioFila = lista.get(position)
        holder.nombre.setText(usuarioFila.nombre)
        holder.correo.setText(usuarioFila.correo)
        holder.apellido.setText(usuarioFila.apellido)
        /*usuarioFila.apellido
        usuarioFila.nombre
        usuarioFila.edad*/
    }

    // clase anidada
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nombre: TextView
        var correo: TextView
        var apellido: TextView

        init {
            nombre = itemView.findViewById(R.id.nombre_fila)
            correo = itemView.findViewById(R.id.correo_fila)
            apellido = itemView.findViewById(R.id.apellido_fila)
        }

    }
}
