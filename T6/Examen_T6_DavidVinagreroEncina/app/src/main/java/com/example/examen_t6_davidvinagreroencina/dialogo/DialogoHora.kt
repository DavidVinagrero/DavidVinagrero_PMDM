package com.example.examen_t6_davidvinagreroencina.dialogo

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.examen_t6_davidvinagreroencina.R
import com.google.android.material.snackbar.Snackbar
import java.util.*

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var hora = Calendar.getInstance().get(Calendar.HOUR)
        var minu = Calendar.getInstance().get(Calendar.MINUTE)

        val dialogo = TimePickerDialog(context, activity as TimePickerDialog.OnTimeSetListener, hora,minu,true)
        return dialogo

    }
}