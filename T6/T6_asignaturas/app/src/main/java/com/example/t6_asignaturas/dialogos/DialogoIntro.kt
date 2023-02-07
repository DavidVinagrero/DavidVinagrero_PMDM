package com.example.t6_asignaturas.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
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
    private lateinit var botonAceptar: Button

    override fun onStart() {
        super.onStart()
        textoNombre = vista.findViewById(R.id.text_nombre)
        textoProfesor = vista.findViewById(R.id.text_profesor)
        spinnerHora = vista.findViewById(R.id.spinner_hora)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
        botonAceptar = vista.findViewById(R.id.boton_aceptar)

        spinnerHora.adapter = ArrayAdapter
            .createFromResource(requireContext(),R.array.horas,android.R.layout.simple_spinner_item)
        (spinnerHora.adapter as ArrayAdapter<CharSequence>)
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCiclo.adapter = ArrayAdapter
            .createFromResource(requireContext(),R.array.ciclos,android.R.layout.simple_spinner_item)
        (spinnerCiclo.adapter as ArrayAdapter<CharSequence>)
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCurso.adapter = ArrayAdapter
            .createFromResource(requireContext(), R.array.cursos,android.R.layout.simple_spinner_item)
        (spinnerCurso.adapter as ArrayAdapter<CharSequence>)
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun onResume() {
        super.onResume()
        var hora: Int = Integer.parseInt(spinnerHora.selectedItem.toString())
        var ciclo: String = spinnerHora.selectedItem.toString()
        var curso: Int = Integer.parseInt(spinnerHora.selectedItem.toString())

        botonAceptar.setOnClickListener {
            listener.asignaturaSelecter(
                Asignatura(textoNombre.text.toString(),textoProfesor.text.toString(),hora,ciclo,curso)
            )
            dismiss()
        }
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