package com.example.t6_asignaturas.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.t6_asignaturas.R
import com.example.t6_asignaturas.model.Asignatura

class DialogoIntro: DialogFragment() {
    private lateinit var vista: View
    private lateinit var textoNombre: EditText
    private lateinit var textoProfesor: EditText
    private lateinit var spinnerHora: Spinner
    private lateinit var spinnerCiclo: Spinner
    private lateinit var spinnerCurso: Spinner
    private lateinit var listener: OnRecyclerAsignaturasListener

    override fun onStart() {
        super.onStart()
        textoNombre = vista.findViewById(R.id.text_nombre)
        textoProfesor = vista.findViewById(R.id.text_profesor)
        spinnerHora = vista.findViewById(R.id.spinner_hora)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnRecyclerAsignaturasListener
        vista =LayoutInflater.from(context).inflate(R.layout.dialogo_intro,null)
    }

    interface OnRecyclerAsignaturasListener {
        fun asignaturaSelecter(asignatura: Asignatura)
    }
}