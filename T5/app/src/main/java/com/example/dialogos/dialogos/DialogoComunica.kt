package com.example.dialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoComunica : DialogFragment() {

    private lateinit var nombre: String
    private lateinit var apellido: String

    companion object {
        fun newInstance(nombre: String, apellido: String): DialogoComunica {
            val dialogoComunica = DialogoComunica()
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("apellido",apellido)
            dialogoComunica.arguments = bundle

            return dialogoComunica
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = this.arguments?.getString("nombre")?:"asdf"
        apellido = this.arguments?.getString("apellido")?:"asdf"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // recuperar el nombre y ponerlo como título
        // recuperar el nombre, apellido y ponerlo como mensaje

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Bienvendio "+nombre)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}