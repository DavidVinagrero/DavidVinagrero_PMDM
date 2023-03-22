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

class DialogoNota : DialogFragment() {
    private lateinit var vista: View
    private lateinit var listener: OnNotaSelected

    private lateinit var notaInput: EditText
    private lateinit var botonOk: Button

    interface OnNotaSelected {
        fun onNotaDialogoSelected(nota: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_nota, null)
        listener = context as OnNotaSelected
    }

    override fun onStart() {
        super.onStart()
        notaInput = vista.findViewById(R.id.input_nota)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        botonOk = vista.findViewById(R.id.boton_nota)
        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        botonOk.setOnClickListener {
                listener.onNotaDialogoSelected(notaInput.text.toString().toInt())
                dismiss()
        }
    }
}