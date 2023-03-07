package com.example.ejerciciodialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ejerciciodialogos.R

class DialogoComunica: DialogFragment() {

    private var nombreRecuperado: String = ""
    private var horaRecuperada: String = ""
    private var fechaRecuperada: String = "NA"

    private lateinit var textoConfirmacion: TextView
    private lateinit var botonConfirmacion: Button
    private lateinit var vista: View
    private lateinit var listener: OnComunicaListener

    interface OnComunicaListener {
        fun onDialogoComunicaListener()
    }

    override fun onStart() {
        super.onStart()
        botonConfirmacion = vista.findViewById(R.id.boton_confirmacion)

    }

    companion object{
        fun newInstance(nombre: String, hora: String, fecha: String): DialogoComunica {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("hora", hora)
            args.putString("fecha", fecha)
            val fragment = DialogoComunica()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso_comunica, null)
        listener = context as OnComunicaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        textoConfirmacion = vista.findViewById(R.id.texto_confirmacion)

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        nombreRecuperado = this.arguments?.get("nombre").toString()
        horaRecuperada = this.arguments?.get("hora").toString()
        fechaRecuperada = this.arguments?.get("fecha").toString()
        textoConfirmacion.text = "Buenos días $nombreRecuperado, va ha registrar una respuesta el $fechaRecuperada a las $horaRecuperada, ¿Está seguro de querer continuar?"
        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        botonConfirmacion.setOnClickListener{
            listener.onDialogoComunicaListener()
            dismiss()
        }
    }
}