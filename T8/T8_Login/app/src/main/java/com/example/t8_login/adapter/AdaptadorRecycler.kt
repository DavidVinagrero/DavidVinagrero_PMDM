package com.example.t8_login.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t8_login.R

class AdaptadorRecycler: RecyclerView.Adapter<> {

    class MyHolder(itemView: View): ViewHolder(itemView){
        var textoNombre: TextView = itemView.findViewById(R.id.texto_recycler)
    }
}
