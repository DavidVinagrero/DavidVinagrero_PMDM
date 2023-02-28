package com.example.ejerciciodialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.ejerciciodialogos.R

class DialogoComunica: DialogFragment() {

    private lateinit var nombreRecuperado: String
    private lateinit var horaRecuperada: String
    private var fechaRecuperada: String = "NA"

    private lateinit var textoConfirmacion: EditText
    private lateinit var botonConfirmacion: Button
    private lateinit var vista: View



    companion object{
        fun newInstance(nombre: String, hora: String, fecha: String): DialogoComunica {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("hora", hora)
            args.putString("fecha", fecha)
            val fragment = DialogoComunica()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso_comunica, null)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireActivity())
        nombreRecuperado = this.arguments?.get("nombre").toString()
        horaRecuperada = this.arguments?.get("hora").toString()
        fechaRecuperada = this.arguments?.get("fecha").toString()
        textoConfirmacion.setText("Buenos días $nombreRecuperado, va ha registrar una respuesta el $fechaRecuperada a las $horaRecuperada, ¿Está seguro de querer continuar?")
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        textoConfirmacion = vista.findViewById(R.id.texto_confirmacion)
        botonConfirmacion = vista.findViewById(R.id.boton_confirmacion)
    }
}