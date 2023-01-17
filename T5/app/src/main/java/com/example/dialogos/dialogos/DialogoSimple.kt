package com.example.dialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoSimple : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")

        builder.setTitle("Selecciona una opcion")
        builder.setSingleChoiceItems(
            elementos,
            -1,
            DialogInterface.OnClickListener { _, i ->  })


        return builder.create()
    }
}