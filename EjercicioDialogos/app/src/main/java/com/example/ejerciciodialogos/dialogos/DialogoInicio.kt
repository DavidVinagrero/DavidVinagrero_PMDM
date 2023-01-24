package com.example.ejerciciodialogos.dialogos

import android.content.Context
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogoInicio: DialogFragment() {

    private lateinit var textoNombre: EditText
    private lateinit var textoApellido: EditText
    private lateinit var botonAceptar: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}