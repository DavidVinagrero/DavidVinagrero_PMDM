package com.example.dialogos.dialogos

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoConfirmacion: DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var listener: OnDialogoConfirmListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnDialogoConfirmListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // AlertDialog.Builder
        val builder = AlertDialog.Builder(contexto)
        builder.setTitle(getString(R.string.titulo_dialogo_confirmacion))
        builder.setMessage("¿Estas seguro de que quieres continuar?")

        // botones --> Positivo negativo neutral
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado OK")
            listener.onDialogoSelected("Sleccionado OK")
        })
        builder.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado CANCELAR")
            listener.onDialogoSelected("Sleccionado CANCELAR")
        })
        builder.setNeutralButton("SALIR", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado NEUTRAL")
            listener.onDialogoSelected("Sleccionado NEUTRAL")
        })

        return builder.create()
    }

    interface OnDialogoConfirmListener{
        fun onDialogoSelected(comunicacion: String)
    }
}