package com.example.ejerciciodialogos.dialogos

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.time.Month
import java.util.*

class DialogoFecha: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendarioActual: Calendar = Calendar.getInstance();
        val anio= calendarioActual.get(Calendar.YEAR)
        val dia = calendarioActual.get(Calendar.DAY_OF_MONTH)
        val mes =  calendarioActual.get(Calendar.MONTH)

        val dialogoFecha = DatePickerDialog(requireContext(),requireContext() as DatePickerDialog.OnDateSetListener,anio,mes,dia)
        return dialogoFecha
    }
}