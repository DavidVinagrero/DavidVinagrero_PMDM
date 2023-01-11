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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // AlertDialog.Builder
        val builder = AlertDialog.Builder(contexto)
        builder.setTitle(getString(R.string.titulo_dialogo_confirmacion))
        builder.setMessage("¿Estas seguro de que quieres continuar?")

        // botones --> Positivo negativo neutral
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado OK")
        })
        builder.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado CANCELAR")
        })
        builder.setNeutralButton("SALIR", DialogInterface.OnClickListener { _, _ ->
            Log.v("opcion_dialogo","pulsado NEUTRAL")
        })

        return builder.create()
    }

}