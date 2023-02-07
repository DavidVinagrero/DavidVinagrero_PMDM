package com.example.examen_t6_davidvinagreroencina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_t6_davidvinagreroencina.R
import com.example.examen_t6_davidvinagreroencina.dialogo.DialogoDetalle
import com.example.examen_t6_davidvinagreroencina.model.Viaje
import kotlinx.coroutines.NonDisposableHandle.parent

class AdaptadorRecycler(var contexto: Context, var listaDatos: ArrayList<Viaje>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    lateinit var listener: OnRecyclerListener

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        lateinit var botonDetalle: Button
        lateinit var textoViaje: TextView
        lateinit var imagenOrigen: ImageView
        lateinit var imagenDestino: ImageView

        init {
            botonDetalle = view.findViewById(R.id.boton_detalle)
            textoViaje = view.findViewById(R.id.texto_viaje)
            imagenOrigen = view.findViewById(R.id.imagen_origen)
            imagenDestino = view.findViewById(R.id.imagen_destino)
        }
    }

    interface OnRecyclerListener {

    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var viajeCompleto: String = listaDatos.get(position).origen + " - " + listaDatos.get(position).destino
        holder.textoViaje.setText(viajeCompleto)

        when(listaDatos.get(position).origen){
                "Londres"->{holder.imagenOrigen.setImageResource(R.drawable.londres)}
                "Madrid"->{holder.imagenOrigen.setImageResource(R.drawable.madrid)}
                "New York"->{holder.imagenOrigen.setImageResource(R.drawable.newyork)}
                "San Francisco"->{holder.imagenOrigen.setImageResource(R.drawable.sanfrancisco)}
                "Miami"->{holder.imagenOrigen.setImageResource(R.drawable.miami)}
                "Barcelona"->{holder.imagenOrigen.setImageResource(R.drawable.barcelona)}
        }
        when(listaDatos.get(position).destino){
                "Londres"->{holder.imagenDestino.setImageResource(R.drawable.londres)}
                "Madrid"->{holder.imagenDestino.setImageResource(R.drawable.madrid)}
                "New York"->{holder.imagenDestino.setImageResource(R.drawable.newyork)}
                "San Francisco"->{holder.imagenDestino.setImageResource(R.drawable.sanfrancisco)}
                "Miami"->{holder.imagenDestino.setImageResource(R.drawable.miami)}
                "Barcelona"->{holder.imagenDestino.setImageResource(R.drawable.barcelona)}
        }
        holder.botonDetalle.setOnClickListener{

        }
    }
}