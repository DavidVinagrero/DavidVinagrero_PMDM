package com.example.ejerciciodialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.ejerciciodialogos.R

class DialogoInicio: DialogFragment() {

    private lateinit var vista: View
    private lateinit var listener: OnInicioListener

    interface OnInicioListener {
        fun onInicioListenerSelected(nombre:String, apellido:String)
    }

    private lateinit var textoNombre: EditText
    private lateinit var textoApellido: EditText
    private lateinit var botonAceptar: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso_inicio, null)
        listener = context as OnInicioListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        textoNombre = vista.findViewById(R.id.texto_nombre)
        textoApellido = vista.findViewById(R.id.texto_apellido)
        botonAceptar = vista.findViewById(R.id.boton_aceptar)
    }

    override fun onResume() {
        super.onResume()
        botonAceptar.setOnClickListener {
            listener.onInicioListenerSelected(textoNombre.text.toString(), textoApellido.text.toString())
            dismiss()
        }
    }
}