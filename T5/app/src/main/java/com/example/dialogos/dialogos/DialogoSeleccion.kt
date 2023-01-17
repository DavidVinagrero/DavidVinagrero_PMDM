package com.example.dialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoSeleccion: DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var listener: OnDialogoSeleccionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnDialogoSeleccionListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(contexto)
        val elementos = arrayOf("Opción 1","Opción 2","Opción 3","Opción 4")

        builder.setTitle("Seleccione una opcion")
        // builder.setMessage("NO PUEDE TENER MENSAJE")
        builder.setItems(elementos, DialogInterface.OnClickListener { _, i ->
            Log.v("opcion_dialogo","Pulsado ${i}")
            listener.onDialogoSeleccionSelected("Opcion ${i+1}")
        })

        return builder.create()
    }

    interface OnDialogoSeleccionListener{
        fun onDialogoSeleccionSelected(comunicado: String)
    }
}