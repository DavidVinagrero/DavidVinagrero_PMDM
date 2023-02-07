package com.example.examen_t6_davidvinagreroencina.dialogo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.examen_t6_davidvinagreroencina.R
import com.example.examen_t6_davidvinagreroencina.model.Viaje

class DialogoDetalle : DialogFragment() {

    lateinit var vista: View;

    lateinit var textoOrigen: TextView
    lateinit var textoDestino: TextView
    lateinit var textoFechaOrigen: TextView
    lateinit var textoFechaDestino: TextView
    lateinit var textoHoraOrigen: TextView
    lateinit var textoHoraDestino: TextView
    lateinit var botonCerrar: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_fin, null);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        var lugarOrigen = this.arguments?.get("lugar_origen")
        var lugarDestino = this.arguments?.get("lugar_destino")
        var diaOrigen = this.arguments?.get("fecha_origen")
        var diaDestino = this.arguments?.get("fecha_destino")
        var minutoOrigen = this.arguments?.get("hora_origen")
        var minutoDestino = this.arguments?.get("hora_destino")
        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        botonCerrar.setOnClickListener{
            dismiss()
        }
    }

    companion object{
        fun newInstance(origen: String, destino:String, fechaOrigen:String, fechaDestino:String, horaOrigen:String, horaDestino:String): DialogoDetalle {
            val args = Bundle()
            args.putString("lugar_origen",origen)
            args.putString("lugar_destino",destino)
            args.putString("fecha_origen",fechaOrigen)
            args.putString("fecha_destino",fechaDestino)
            args.putString("hora_origen",horaOrigen)
            args.putString("hora_destino",horaDestino)
            val fragment = DialogoDetalle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        textoOrigen = vista.findViewById(R.id.texto_origen);
        textoDestino = vista.findViewById(R.id.texto_destino);
        textoFechaOrigen = vista.findViewById(R.id.fecha_origen);
        textoFechaDestino = vista.findViewById(R.id.fecha_destino);
        textoHoraOrigen = vista.findViewById(R.id.hora_origen);
        textoHoraDestino = vista.findViewById(R.id.hora_destino);
        botonCerrar = vista.findViewById(R.id.boton_cerrar)

    }
}