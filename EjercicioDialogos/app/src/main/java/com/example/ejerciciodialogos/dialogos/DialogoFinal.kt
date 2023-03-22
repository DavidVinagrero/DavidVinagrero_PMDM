package com.example.ejerciciodialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.ejerciciodialogos.R

class DialogoFinal : DialogFragment() {
    private var horaRecuperada: String = ""
    private var fechaRecuperada: String = ""
    private var nombreRecuperado: String = ""
    private var asignaturaRecuperada: String = ""
    private var notaRecuperada: Int = 0

    private lateinit var listener: OnDialogoFinalListener

    interface OnDialogoFinalListener {
        fun onDialogSelected()
    }

    private lateinit var vista: View
    private lateinit var textoFin: TextView

    override fun onStart() {
        super.onStart()
        textoFin = vista.findViewById(R.id.texto_final)
    }

    companion object {
        fun newInstance(
            nombre: String,
            fecha: String,
            hora: String,
            asignatura: String,
            nota: Int
        ): DialogoNota {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("fecha", fecha)
            args.putString("hora", hora)
            args.putString("asignatura", asignatura)
            args.putInt("nota", nota)
            val fragment = DialogoNota()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_final, null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)

        horaRecuperada = this.arguments?.get("hora").toString()
        fechaRecuperada = this.arguments?.get("fehca").toString()
        nombreRecuperado = this.arguments?.get("nombre").toString()
        asignaturaRecuperada = this.arguments?.get("asignatura").toString()
        notaRecuperada = this.arguments?.getInt("nota").toString().toInt()

        textoFin.text =
            "-Nombre y apellidos: $nombreRecuperado\n-Hora: $horaRecuperada\n-Fecha: $fechaRecuperada\n-Asignaturas a evaluar: $asignaturaRecuperada\n-Nota media: $notaRecuperada"

        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        listener.onDialogSelected()
        dismiss()
    }
}