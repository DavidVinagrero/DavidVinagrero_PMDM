package com.example.examen_t6_davidvinagreroencina.dialogo

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DialogoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val anio = Calendar.getInstance().get(Calendar.YEAR)
        val mes = Calendar.getInstance().get(Calendar.MONTH)
        val day = Calendar.getInstance().get(Calendar.DATE)

        val dialogoHora = DatePickerDialog(requireContext(),activity as DatePickerDialog.OnDateSetListener,anio,mes,day)
        return dialogoHora
    }
}