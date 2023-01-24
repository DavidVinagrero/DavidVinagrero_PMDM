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

class DialogoConfirmacion : DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var listener: OnDialogoConfirmListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnDialogoConfirmListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // AlertDialgo.Builder
        //val builder = AlertDialog.Builder(requireContext())
        val builder = AlertDialog.Builder(contexto)
        builder.setTitle("Continuar")
        //builder.setTitle(getString(R.string.titulo_dialogo_confirm))
        builder.setMessage("¿Estas seguro que quieres continuar?")

        // botones -- Positivo negativo neutral
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _,_ ->
            Log.v("dialogo","PULSADO OK")
            listener.onDialogoSelected("Seleccionado OK")
        })

        builder.setNegativeButton("CANCEL", DialogInterface.OnClickListener { _,_ ->
            Log.v("dialogo","PULSADO CANCELAR")
            listener.onDialogoSelected("Seleccionado CANCEL")
        })

        builder.setNeutralButton("SALIR", DialogInterface.OnClickListener { _,_ ->
            Log.v("dialogo","PULSADO SALIR")
        })
        return builder.create()
    }

    interface OnDialogoConfirmListener{
        fun onDialogoSelected(comunicacion: String)
    }
}