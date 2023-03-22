package com.example.ejercicio_empresa.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ejercicio_empresa.R

class DialogoEmpleado: DialogFragment() {
    private lateinit var textoEmpleado: TextView
    private lateinit var vista: View

    override fun onStart() {
        super.onStart()
        textoEmpleado = vista.findViewById(R.id.texto_info)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_empleado, null)
    }

    companion object{
        fun newInstance(texto: String): DialogoEmpleado {


            val args = Bundle()
            args.putString("texto", texto)
            val fragment = DialogoEmpleado()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireActivity())
        textoEmpleado.text = savedInstanceState.toString()
        return builder.create()
    }

}